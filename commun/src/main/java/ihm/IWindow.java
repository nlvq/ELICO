package ihm;

/**
 * Base interface for all windows.
 */
public interface IWindow {
    /**
     * Create the window, do not open it.
     */
    public void createWindow();

    /**
     * Open the window
     */
    public void openWindow();

    /**
     * Close the window.
     */
    public void closeWindow();
}
