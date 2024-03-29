/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.awt.Container;
import java.awt.EventQueue;
import javax.microedition.xlet.UnavailableContainerException;
import javax.microedition.xlet.XletContext;
import javax.microedition.xlet.XletStateChangeException;

/**
 * @author SamAsEnd
 */
public class NewAGUIXlet extends javax.swing.JInternalFrame implements javax.microedition.xlet.Xlet {
    
    private XletContext context;            // our Xlet application context.
    private Container rootContainer;        // the root container of our screen.

    /**
     * Creates new form NewAGUIXlet
     */
    public NewAGUIXlet() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 252, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 282, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public void initXlet(final XletContext xletContext) throws XletStateChangeException {
        context = xletContext;        
        if (rootContainer == null) {
            try {
                //This call to getContainer() tells the OS we want to be a graphical app.
                rootContainer = context.getContainer();
            } catch (UnavailableContainerException e) {
                System.out.println("Ouch ! could not get our container!");
                // If we can't get the root container,
                // abort the initialization
                throw new XletStateChangeException("Start aborted -- no container: "
                        + e.getMessage());
            }
        }        
    }
    
    public void startXlet() throws XletStateChangeException {
        // Note: Swing thread constraints still apply in an Xlet... most operations
        // need to be on the event thread, and this invokeLater does that.
        try {
            // using invokeAndWait to avoid writing synchornization code.
            // invokeLater would work just as well in most cases.
            EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    NewAGUIXlet.this.setVisible(true);
                    rootContainer.add(NewAGUIXlet.this);
                    // This is needed - or nothing will be displayed.
                    rootContainer.setVisible(true);
                }
            });
        } catch (Exception e) {
            System.out.println("Ouch - exception in invokeAndWait()");
            e.printStackTrace();
            exit();
        }
    }
    
    public void pauseXlet() {
        //This is pure overkill for this application, but is done to demonstrate the point.
        //We are freeing up our only resources (the screen), and we will rebuild it when
        //we get started again. If you took out this block - the application should still
        //run perfectly, and the screen should only be created once.
        try {
            // using invokeAndWait to avoid writing synchornization code.
            // invokeLater would work just as well in most cases.
            EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    rootContainer.remove(NewAGUIXlet.this);
                }
            });
        } catch (Exception e) {
            System.out.println("Ouch - exception in invokeAndWait()");
            e.printStackTrace();
            exit();
        }
    }
    
    public void destroyXlet(boolean b) throws XletStateChangeException {
        System.out.println("HelloXet.destroylet() - goodbye");
    }
    
    public void exit() {
        rootContainer.setVisible(false);
        context.notifyDestroyed();
    }    
}
