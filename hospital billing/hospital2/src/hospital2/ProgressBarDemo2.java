/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital2;

/**
 *
 * @author Rishabh
 */
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class ProgressBarDemo2 extends JPanel implements ActionListener,
   
      
        PropertyChangeListener {

  private JProgressBar progressBar;
  private JButton startButton;
  private JButton getinto;
  private JTextArea taskOutput;
  private Task task;
  JLabel head;
static JFrame frame;
  class Task extends SwingWorker<Void, Void> {
    /*
     * Main task. Executed in background thread.
     */
      
    @Override
    public Void doInBackground() {
      Random random = new Random();
      int progress = 0;
      // Initialize progress property.
      setProgress(0);
      // Sleep for at least one second to simulate "startup".
      try {
        Thread.sleep(1000 + random.nextInt(2000));
      } catch (InterruptedException ignore) {
      }
      while (progress < 100) {
        // Sleep for up to one second.
        try {
          Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException ignore) {
        }
        // Make random progress.
        progress += random.nextInt(10);
        setProgress(Math.min(progress, 100));
      }
      return null;
    }

    /*
     * Executed in event dispatch thread
     */
    public void done() {
      Toolkit.getDefaultToolkit().beep();
      startButton.setEnabled(false);
      getinto.setEnabled(true);
      taskOutput.append("Loading Completed!\n\nPress the Proceed Button to Continue");
      
    }
  }

  public ProgressBarDemo2() {
    super(new BorderLayout());

    // Create the demo's UI.
    startButton = new JButton("Enter");
    head=new javax.swing.JLabel();
    head.setFont(new java.awt.Font("Tahoma",1,18));
    head.setText("SDR Hospital Billing Portal.");
    head.setVisible(true);
    startButton.setActionCommand("start");
    startButton.addActionListener(this);
    getinto=new javax.swing.JButton("Proceed");
   getinto.addMouseListener(new java.awt.event.MouseAdapter() {
       public void mouseClicked(java.awt.event.MouseEvent evt)
       {
           getintoMouseClicked(evt);
       }
   });
  
    progressBar = new JProgressBar(0, 100);
    progressBar.setValue(0);

    // Call setStringPainted now so that the progress bar height
    // stays the same whether or not the string is shown.
    progressBar.setStringPainted(true);

    taskOutput = new JTextArea(5, 25);
    taskOutput.setMargin(new Insets(5, 5, 5, 5));
    taskOutput.setEditable(false);

    JPanel panel = new JPanel();
    //panel.
   
    panel.add(startButton);
    panel.add(progressBar);
    panel.add(getinto);
    
    getinto.setEnabled(false);
    add(panel, BorderLayout.PAGE_START);
    add(new JScrollPane(taskOutput), BorderLayout.CENTER);
    setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
    //createAndShowGUI();
    
  }

  /**
   * Invoked when the user presses the start button.
   */
  public void actionPerformed(ActionEvent evt) {
    progressBar.setIndeterminate(true);
    startButton.setEnabled(false);
    getinto.setEnabled(false);
    // Instances of javax.swing.SwingWorker are not reusuable, so
    // we create new instances as needed.
    task = new Task();
    task.addPropertyChangeListener(this);
    task.execute();
  }

  /**
   * Invoked when task's progress property changes.
   */
  public void propertyChange(PropertyChangeEvent evt) {
    if ("progress" == evt.getPropertyName()) {
      int progress = (Integer) evt.getNewValue();
      progressBar.setIndeterminate(false);
      progressBar.setValue(progress);
      taskOutput.append(String.format("Loading %d%%\n", progress));
    }
  }

  /**
   * Create the GUI and show it. As with all GUI code, this must run on the
   * event-dispatching thread.
   */
  private static void createAndShowGUI() {
    // Create and set up the window.
    frame = new JFrame("Loding SDR Hospital Billig Portal....");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create and set up the content pane.
    JComponent newContentPane = new ProgressBarDemo2();
    newContentPane.setOpaque(true); // content panes must be opaque
    frame.setContentPane(newContentPane);

    // Display the window.
    frame.pack();
    frame.setBounds(400, 200,500,300);
    frame.setVisible(true);
  }
  private void getintoMouseClicked(java.awt.event.MouseEvent evt)
  {
      enter l=new enter();
      super.setVisible(false);
      l.setVisible(true);
      frame.setVisible(false);
  }
  public static void main(String[] args) {
    // Schedule a job for the event-dispatching thread:
    // creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
      public void run() {
                //new ProgressBarDemo2().setVisible(true);
                createAndShowGUI();
      }
    });
  }
}