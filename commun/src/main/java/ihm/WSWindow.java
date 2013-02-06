package ihm;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class WSWindow extends AbstractWorkPaneWindow implements TreeSelectionListener {

	//déclaration des variables

	private JTree tree;
	private View view = new View();

	//déclaration de la racine de l'arbre
	private DefaultMutableTreeNode root;

	//création du panneau gauche

	@Override
	void createLeftPane(JPanel panel) {
		panel.setPreferredSize(panel.getMaximumSize());
		panel.setBackground(Color.BLUE);

	}

	//création du panneau droite

	@Override
	void createRightPane(JPanel panel) {
		panel.setPreferredSize(panel.getMaximumSize());
		panel.setBackground(Color.RED);
	}

	//création des boutons 

	@Override
	void createButtonPane(JPanel panel) {
		panel.add(new JButton("A"));
		panel.add(new JButton("Pu"));
		panel.add(new JButton("Pr"));
		panel.add(new JButton("S"));
		panel.add(new JButton("?"));
		createTree();
		panel.add(new JScrollPane(tree));
	}

	//création de l'arbre

	private void createTree() {
		this.root = new DefaultMutableTreeNode();       
		for(File file : File.listRoots()){
			DefaultMutableTreeNode read = 
					new DefaultMutableTreeNode(file.getAbsolutePath());
			try {
				for(File nom : file.listFiles()){
					DefaultMutableTreeNode node = new DefaultMutableTreeNode(nom.getName()+"\\");               
					read.add(this.listFile(nom, node));               
				}
			} catch (NullPointerException e) {}

			this.root.add(read);                 
		}
		tree = new JTree(this.root);
		tree.setPreferredSize(new Dimension(180, 600));
		tree.addTreeSelectionListener(this);
	}

	//afficher un exemple de navigation en images

	private class View extends JComponent {
		private BufferedImage photo;
		private double ratio;

		@Override
		protected void paintComponent(Graphics g) {
			if (photo!=null)  g.drawImage(photo, 0, 0, getWidth(), (int)(getWidth()/ratio), null);
		}

		public void setPhoto(File fichier) {
			try {
				photo = ImageIO.read(fichier);
				ratio = (double)photo.getWidth() / photo.getHeight();
				repaint();    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       
		}
	}

	//lister des fichiers ou des répertoires d'une noeud selectionnée

	private DefaultMutableTreeNode listFile(File file, DefaultMutableTreeNode node){
		int count = 0;

		if(file.isFile())
			return new DefaultMutableTreeNode(file.getName());
		else{
			File[] list = file.listFiles();
			if(list == null)
				return new DefaultMutableTreeNode(file.getName());

			for(File nom : list){
				count++;
				//Pas plus de 10 enfants par noeud
				if(count < 10){
					DefaultMutableTreeNode subNode;
					if(nom.isDirectory()){
						subNode = new DefaultMutableTreeNode(nom.getName()+"\\");
						node.add(this.listFile(nom, subNode));
					}else{
						subNode = new DefaultMutableTreeNode(nom.getName());
					}
					node.add(subNode);
				}
			}
			return node;
		}
	}


	//action à faire quand on sélectionne un fichier 

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		if (tree.getSelectionPath()!=null) {
			String nom = tree.getSelectionPath().getLastPathComponent().toString();
			view.setPhoto(new File(nom));
		}
	}
}