/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import io.P2PConnection;
import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.m2g.SVGImage;
import javax.microedition.pim.Contact;
import javax.microedition.pim.PIM;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.MessageListener;
import org.netbeans.microedition.lcdui.WaitScreen;
import org.netbeans.microedition.lcdui.pda.PIMBrowser;
import org.netbeans.microedition.svg.SVGWaitScreen;
import org.netbeans.microedition.util.SimpleCancellableTask;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGMatrix;
import smsconnect.MessageReceiver;
import smsconnect.SMSservice;

/**
 * @author Chris2u
 */
public class MainMIDlet extends MIDlet implements CommandListener, MessageListener {

    private boolean midletPaused = false;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form startForm;
    private WaitScreen waitForSMSscreen;
    private PIMBrowser pimBrowser;
    private WaitScreen waitForConfirmationScreen;
    private Alert alertSMSFailure;
    private Gauge indicator;
    private Alert alertAskRetry;
    private SVGWaitScreen FFGuideScreen;
    private Command exitCommand;
    private Command startCommand;
    private Command okCommand;
    private Command cancelCommand;
    private Command cancelCommand1;
    private Command stopCommand;
    private Command okCommand1;
    private Command stopCommand1;
    private SimpleCancellableTask task;
    private Ticker ticker1;
    private SimpleCancellableTask task1;
    private Ticker ticker2;
    private SVGImage svgImage;
    private Image image;
    private SimpleCancellableTask task2;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The MainMIDlet constructor.
     */
    public MainMIDlet() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // try to add SMSService to PUSH-registry
        SMSservice.register();
        try {
            // Start a message processor thread, to process all messages for the connection.
            SMSservice.getMessageConnection().setMessageListener(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getStartForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
        new Thread(new _Fill2Contacts()).start();
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == FFGuideScreen) {//GEN-BEGIN:|7-commandAction|1|105-preAction
            if (command == SVGWaitScreen.FAILURE_COMMAND) {//GEN-END:|7-commandAction|1|105-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|2|105-postAction
                // write post-action user code here
            } else if (command == SVGWaitScreen.SUCCESS_COMMAND) {//GEN-LINE:|7-commandAction|3|104-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|4|104-postAction
                // write post-action user code here
            } else if (command == stopCommand1) {//GEN-LINE:|7-commandAction|5|108-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|6|108-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|7|79-preAction
        } else if (displayable == alertAskRetry) {
            if (command == cancelCommand1) {//GEN-END:|7-commandAction|7|79-preAction
                task1.cancel();
                switchDisplayable(null, getStartForm());//GEN-LINE:|7-commandAction|8|79-postAction
                // write post-action user code here
            } else if (command == okCommand1) {//GEN-LINE:|7-commandAction|9|81-preAction
                task1.cancel();
                switchDisplayable(null, getWaitForSMSscreen());//GEN-LINE:|7-commandAction|10|81-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|51-preAction
        } else if (displayable == pimBrowser) {
            if (command == PIMBrowser.SELECT_PIM_ITEM) {//GEN-END:|7-commandAction|11|51-preAction
                // write pre-action user code here
                switchDisplayable(null, getWaitForSMSscreen());//GEN-LINE:|7-commandAction|12|51-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|13|16-preAction
        } else if (displayable == startForm) {
            if (command == exitCommand) {//GEN-END:|7-commandAction|13|16-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|14|16-postAction
                // write post-action user code here
            } else if (command == startCommand) {//GEN-LINE:|7-commandAction|15|19-preAction
                // write pre-action user code here
                switchDisplayable(null, getPimBrowser());//GEN-LINE:|7-commandAction|16|19-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|56-preAction
        } else if (displayable == waitForConfirmationScreen) {
            if (command == WaitScreen.FAILURE_COMMAND) {//GEN-END:|7-commandAction|17|56-preAction
                // write pre-action user code here
                switchDisplayable(getAlertAskRetry(), getWaitForConfirmationScreen());//GEN-LINE:|7-commandAction|18|56-postAction
                // write post-action user code here
            } else if (command == WaitScreen.SUCCESS_COMMAND) {//GEN-LINE:|7-commandAction|19|55-preAction
                // write pre-action user code here
                switchDisplayable(null, getFFGuideScreen().getSvgCanvas());//GEN-LINE:|7-commandAction|20|55-postAction
                // write post-action user code here
            } else if (command == stopCommand) {//GEN-LINE:|7-commandAction|21|75-preAction
                // write pre-action user code here
                switchDisplayable(getAlertAskRetry(), getWaitForConfirmationScreen());//GEN-LINE:|7-commandAction|22|75-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|23|30-preAction
        } else if (displayable == waitForSMSscreen) {
            if (command == WaitScreen.FAILURE_COMMAND) {//GEN-END:|7-commandAction|23|30-preAction
                // write pre-action user code here
                switchDisplayable(getAlertSMSFailure(), getPimBrowser());//GEN-LINE:|7-commandAction|24|30-postAction
                // write post-action user code here
            } else if (command == WaitScreen.SUCCESS_COMMAND) {//GEN-LINE:|7-commandAction|25|29-preAction
                // write pre-action user code here
                switchDisplayable(null, getWaitForConfirmationScreen());//GEN-LINE:|7-commandAction|26|29-postAction
                // write post-action user code here
            } else if (command == cancelCommand) {//GEN-LINE:|7-commandAction|27|72-preAction
                // write pre-action user code here
                switchDisplayable(getAlertSMSFailure(), getPimBrowser());//GEN-LINE:|7-commandAction|28|72-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|29|7-postCommandAction
        }//GEN-END:|7-commandAction|29|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|30|
    //</editor-fold>//GEN-END:|7-commandAction|30|





    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: startForm ">//GEN-BEGIN:|13-getter|0|13-preInit
    /**
     * Returns an initiliazed instance of startForm component.
     * @return the initialized component instance
     */
    public Form getStartForm() {
        if (startForm == null) {//GEN-END:|13-getter|0|13-preInit
            // write pre-init user code here
            startForm = new Form("Friend-Finder 0.1");//GEN-BEGIN:|13-getter|1|13-postInit
            startForm.addCommand(getExitCommand());
            startForm.addCommand(getStartCommand());
            startForm.setCommandListener(this);//GEN-END:|13-getter|1|13-postInit
            // write post-init user code here
        }//GEN-BEGIN:|13-getter|2|
        return startForm;
    }
    //</editor-fold>//GEN-END:|13-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: waitForSMSscreen ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initiliazed instance of waitForSMSscreen component.
     * @return the initialized component instance
     */
    public WaitScreen getWaitForSMSscreen() {
        if (waitForSMSscreen == null) {//GEN-END:|26-getter|0|26-preInit
            // write pre-init user code here
            waitForSMSscreen = new WaitScreen(getDisplay());//GEN-BEGIN:|26-getter|1|26-postInit
            waitForSMSscreen.setTitle("Anfrage versenden");
            waitForSMSscreen.setTicker(getTicker2());
            waitForSMSscreen.addCommand(getCancelCommand());
            waitForSMSscreen.setCommandListener(this);
            waitForSMSscreen.setText("");
            waitForSMSscreen.setTask(getTask());//GEN-END:|26-getter|1|26-postInit
            // write post-init user code here
        }//GEN-BEGIN:|26-getter|2|
        return waitForSMSscreen;
    }
    //</editor-fold>//GEN-END:|26-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|15-getter|0|15-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|15-getter|0|15-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|15-getter|1|15-postInit
            // write post-init user code here
        }//GEN-BEGIN:|15-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|15-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: startCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of startCommand component.
     * @return the initialized component instance
     */
    public Command getStartCommand() {
        if (startCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            startCommand = new Command("Start", "Verbindung mit einer anderen Person anfordern und Suchvorgang starten", Command.ITEM, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return startCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|20-getter|0|20-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|20-getter|0|20-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|20-getter|1|20-postInit
            // write post-init user code here
        }//GEN-BEGIN:|20-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|20-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: task ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initiliazed instance of task component.
     * @return the initialized component instance
     */
    public SimpleCancellableTask getTask() {
        if (task == null) {//GEN-END:|31-getter|0|31-preInit
            // write pre-init user code here
            task = new SimpleCancellableTask();//GEN-BEGIN:|31-getter|1|31-execute
            task.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {//GEN-END:|31-getter|1|31-execute
                    P2PConnection.request((Contact) getPimBrowser().getSelectedItem());
                }//GEN-BEGIN:|31-getter|2|31-postInit
            });//GEN-END:|31-getter|2|31-postInit
            // write post-init user code here
        }//GEN-BEGIN:|31-getter|3|
        return task;
    }
    //</editor-fold>//GEN-END:|31-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: pimBrowser ">//GEN-BEGIN:|50-getter|0|50-preInit
    /**
     * Returns an initiliazed instance of pimBrowser component.
     * @return the initialized component instance
     */
    public PIMBrowser getPimBrowser() {
        if (pimBrowser == null) {//GEN-END:|50-getter|0|50-preInit
            // write pre-init user code here
            pimBrowser = new PIMBrowser(getDisplay(), PIM.CONTACT_LIST);//GEN-BEGIN:|50-getter|1|50-postInit
            pimBrowser.setTitle("Kontakt ausw\u00E4hlen");
            pimBrowser.addCommand(PIMBrowser.SELECT_PIM_ITEM);
            pimBrowser.setCommandListener(this);//GEN-END:|50-getter|1|50-postInit
            // write post-init user code here
        }//GEN-BEGIN:|50-getter|2|
        return pimBrowser;
    }
    //</editor-fold>//GEN-END:|50-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: waitForConfirmationScreen ">//GEN-BEGIN:|54-getter|0|54-preInit
    /**
     * Returns an initiliazed instance of waitForConfirmationScreen component.
     * @return the initialized component instance
     */
    public WaitScreen getWaitForConfirmationScreen() {
        if (waitForConfirmationScreen == null) {//GEN-END:|54-getter|0|54-preInit
            // write pre-init user code here
            waitForConfirmationScreen = new WaitScreen(getDisplay());//GEN-BEGIN:|54-getter|1|54-postInit
            waitForConfirmationScreen.setTitle("Warte auf Zustimmung ...");
            waitForConfirmationScreen.setTicker(getTicker1());
            waitForConfirmationScreen.addCommand(getStopCommand());
            waitForConfirmationScreen.setCommandListener(this);
            waitForConfirmationScreen.setText("");
            waitForConfirmationScreen.setTask(getTask1());//GEN-END:|54-getter|1|54-postInit
            // write post-init user code here
        }//GEN-BEGIN:|54-getter|2|
        return waitForConfirmationScreen;
    }
    //</editor-fold>//GEN-END:|54-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: task1 ">//GEN-BEGIN:|57-getter|0|57-preInit
    /**
     * Returns an initiliazed instance of task1 component.
     * @return the initialized component instance
     */
    public SimpleCancellableTask getTask1() {
        if (task1 == null) {//GEN-END:|57-getter|0|57-preInit
            // write pre-init user code here
            task1 = new SimpleCancellableTask();//GEN-BEGIN:|57-getter|1|57-execute
            task1.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {//GEN-END:|57-getter|1|57-execute
                    int counter = 60;
                    while (counter>0) {
                        waitForConfirmationScreen.setText("Warte noch "+counter--+" Sekunden");
                        // ask Service-Listener for incoming data
                        Thread.sleep(1000);
                        // TEST
                        if (counter < 56)
                            return;
                    }
                    
                }//GEN-BEGIN:|57-getter|2|57-postInit
            });//GEN-END:|57-getter|2|57-postInit
            // write post-init user code here
        }//GEN-BEGIN:|57-getter|3|
        return task1;
    }
    //</editor-fold>//GEN-END:|57-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ticker1 ">//GEN-BEGIN:|58-getter|0|58-preInit
    /**
     * Returns an initiliazed instance of ticker1 component.
     * @return the initialized component instance
     */
    public Ticker getTicker1() {
        if (ticker1 == null) {//GEN-END:|58-getter|0|58-preInit
            // write pre-init user code here
            ticker1 = new Ticker("Bitte warten Sie, bis die Gegenpartei Ihrer Anfrage zugestimmt hat.");//GEN-LINE:|58-getter|1|58-postInit
            // write post-init user code here
        }//GEN-BEGIN:|58-getter|2|
        return ticker1;
    }
    //</editor-fold>//GEN-END:|58-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alertSMSFailure ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initiliazed instance of alertSMSFailure component.
     * @return the initialized component instance
     */
    public Alert getAlertSMSFailure() {
        if (alertSMSFailure == null) {//GEN-END:|60-getter|0|60-preInit
            // write pre-init user code here
            alertSMSFailure = new Alert("Fehler", "SMS konnte nicht verschickt werden", null, AlertType.ERROR);//GEN-BEGIN:|60-getter|1|60-postInit
            alertSMSFailure.setIndicator(getIndicator());
            alertSMSFailure.setTimeout(3);//GEN-END:|60-getter|1|60-postInit
            // write post-init user code here
        }//GEN-BEGIN:|60-getter|2|
        return alertSMSFailure;
    }
    //</editor-fold>//GEN-END:|60-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: indicator ">//GEN-BEGIN:|68-getter|0|68-preInit
    /**
     * Returns an initiliazed instance of indicator component.
     * @return the initialized component instance
     */
    public Gauge getIndicator() {
        if (indicator == null) {//GEN-END:|68-getter|0|68-preInit
            // write pre-init user code here
            indicator = new Gauge(null, false, 100, 50);//GEN-LINE:|68-getter|1|68-postInit
            // write post-init user code here
        }//GEN-BEGIN:|68-getter|2|
        return indicator;
    }
    //</editor-fold>//GEN-END:|68-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ticker2 ">//GEN-BEGIN:|69-getter|0|69-preInit
    /**
     * Returns an initiliazed instance of ticker2 component.
     * @return the initialized component instance
     */
    public Ticker getTicker2() {
        if (ticker2 == null) {//GEN-END:|69-getter|0|69-preInit
            // write pre-init user code here
            ticker2 = new Ticker("Bitte warten Sie, w\u00E4hrend ihre Anfrage versendet wird");//GEN-LINE:|69-getter|1|69-postInit
            // write post-init user code here
        }//GEN-BEGIN:|69-getter|2|
        return ticker2;
    }
    //</editor-fold>//GEN-END:|69-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alertAskRetry ">//GEN-BEGIN:|70-getter|0|70-preInit
    /**
     * Returns an initiliazed instance of alertAskRetry component.
     * @return the initialized component instance
     */
    public Alert getAlertAskRetry() {
        if (alertAskRetry == null) {//GEN-END:|70-getter|0|70-preInit
            // write pre-init user code here
            alertAskRetry = new Alert("Noch versuchen?", "Wollen Sie die Anfrage erneut schicken?", null, AlertType.CONFIRMATION);//GEN-BEGIN:|70-getter|1|70-postInit
            alertAskRetry.addCommand(getCancelCommand1());
            alertAskRetry.addCommand(getOkCommand1());
            alertAskRetry.setCommandListener(this);
            alertAskRetry.setTimeout(Alert.FOREVER);//GEN-END:|70-getter|1|70-postInit
            // write post-init user code here
        }//GEN-BEGIN:|70-getter|2|
        return alertAskRetry;
    }
    //</editor-fold>//GEN-END:|70-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand ">//GEN-BEGIN:|71-getter|0|71-preInit
    /**
     * Returns an initiliazed instance of cancelCommand component.
     * @return the initialized component instance
     */
    public Command getCancelCommand() {
        if (cancelCommand == null) {//GEN-END:|71-getter|0|71-preInit
            // write pre-init user code here
            cancelCommand = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|71-getter|1|71-postInit
            // write post-init user code here
        }//GEN-BEGIN:|71-getter|2|
        return cancelCommand;
    }
    //</editor-fold>//GEN-END:|71-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stopCommand ">//GEN-BEGIN:|74-getter|0|74-preInit
    /**
     * Returns an initiliazed instance of stopCommand component.
     * @return the initialized component instance
     */
    public Command getStopCommand() {
        if (stopCommand == null) {//GEN-END:|74-getter|0|74-preInit
            // write pre-init user code here
            stopCommand = new Command("Stop", Command.STOP, 0);//GEN-LINE:|74-getter|1|74-postInit
            // write post-init user code here
        }//GEN-BEGIN:|74-getter|2|
        return stopCommand;
    }
    //</editor-fold>//GEN-END:|74-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand1 ">//GEN-BEGIN:|78-getter|0|78-preInit
    /**
     * Returns an initiliazed instance of cancelCommand1 component.
     * @return the initialized component instance
     */
    public Command getCancelCommand1() {
        if (cancelCommand1 == null) {//GEN-END:|78-getter|0|78-preInit
            // write pre-init user code here
            cancelCommand1 = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|78-getter|1|78-postInit
            // write post-init user code here
        }//GEN-BEGIN:|78-getter|2|
        return cancelCommand1;
    }
    //</editor-fold>//GEN-END:|78-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|80-getter|0|80-preInit
    /**
     * Returns an initiliazed instance of okCommand1 component.
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {//GEN-END:|80-getter|0|80-preInit
            // write pre-init user code here
            okCommand1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|80-getter|1|80-postInit
            // write post-init user code here
        }//GEN-BEGIN:|80-getter|2|
        return okCommand1;
    }
    //</editor-fold>//GEN-END:|80-getter|2|





    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: image ">//GEN-BEGIN:|89-getter|0|89-preInit
    /**
     * Returns an initiliazed instance of image component.
     * @return the initialized component instance
     */
    public Image getImage() {
        if (image == null) {//GEN-END:|89-getter|0|89-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|89-getter|1|89-@java.io.IOException
                image = Image.createImage("/back_f2.png");
            } catch (java.io.IOException e) {//GEN-END:|89-getter|1|89-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|89-getter|2|89-postInit
            // write post-init user code here
        }//GEN-BEGIN:|89-getter|3|
        return image;
    }
    //</editor-fold>//GEN-END:|89-getter|3|





    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: svgImage ">//GEN-BEGIN:|95-getter|0|95-preInit
    /**
     * Returns an initiliazed instance of svgImage component.
     * @return the initialized component instance
     */
    public SVGImage getSvgImage() {
        if (svgImage == null) {//GEN-END:|95-getter|0|95-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|95-getter|1|95-@java.io.IOException
                svgImage = (SVGImage) SVGImage.createImage(getClass().getResourceAsStream("/Arrow.svg"), null);
            } catch (java.io.IOException e) {//GEN-END:|95-getter|1|95-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|95-getter|2|95-postInit
        }//GEN-BEGIN:|95-getter|3|
        return svgImage;
    }
    //</editor-fold>//GEN-END:|95-getter|3|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: FFGuideScreen ">//GEN-BEGIN:|101-getter|0|101-preInit
    /**
     * Returns an initiliazed instance of FFGuideScreen component.
     * @return the initialized component instance
     */
    public SVGWaitScreen getFFGuideScreen() {
        if (FFGuideScreen == null) {//GEN-END:|101-getter|0|101-preInit
            // write pre-init user code here
            FFGuideScreen = new SVGWaitScreen(getSvgImage(), getDisplay());//GEN-BEGIN:|101-getter|1|101-postInit
            FFGuideScreen.setTitle("Friend Finder Guide");
            FFGuideScreen.addCommand(getStopCommand1());
            FFGuideScreen.setCommandListener(this);
            FFGuideScreen.setTask(getTask2());//GEN-END:|101-getter|1|101-postInit
            // write post-init user code here
        }//GEN-BEGIN:|101-getter|2|
        return FFGuideScreen;
    }
    //</editor-fold>//GEN-END:|101-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stopCommand1 ">//GEN-BEGIN:|107-getter|0|107-preInit
    /**
     * Returns an initiliazed instance of stopCommand1 component.
     * @return the initialized component instance
     */
    public Command getStopCommand1() {
        if (stopCommand1 == null) {//GEN-END:|107-getter|0|107-preInit
            // write pre-init user code here
            stopCommand1 = new Command("Stop", Command.STOP, 0);//GEN-LINE:|107-getter|1|107-postInit
            // write post-init user code here
        }//GEN-BEGIN:|107-getter|2|
        return stopCommand1;
    }
    //</editor-fold>//GEN-END:|107-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: task2 ">//GEN-BEGIN:|106-getter|0|106-preInit
    /**
     * Returns an initiliazed instance of task2 component.
     * @return the initialized component instance
     */
    public SimpleCancellableTask getTask2() {
        if (task2 == null) {//GEN-END:|106-getter|0|106-preInit
            // write pre-init user code here
            task2 = new SimpleCancellableTask();//GEN-BEGIN:|106-getter|1|106-execute
            task2.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {//GEN-END:|106-getter|1|106-execute
                    short direction = 0;
                    double distance = 1.5;
                    while (distance > 0) {
                        direction = 1;
                        distance -= 0.1;
                        FFGuideScreen.invokeAndWaitSafely(new updateGuideScreen(direction, distance));
                        Thread.sleep(1000);
                    }
                }//GEN-BEGIN:|106-getter|2|106-postInit
            });//GEN-END:|106-getter|2|106-postInit
            // write post-init user code here
        }//GEN-BEGIN:|106-getter|3|
        return task2;
    }
    //</editor-fold>//GEN-END:|106-getter|3|













    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
    
    public class updateGuideScreen implements Runnable {

        short direction;
        double distance;
        
        public updateGuideScreen(short direction, double distance) {
            this.direction = direction;
            this.distance = distance;
        }
            
        
        public void run() {
            
            SVGImage i = getSvgImage();
            // rotate arrow
            SVGElement arrow = (SVGElement) i.getDocument().getElementById("arrow");
            SVGMatrix transformMatrix = arrow.getMatrixTrait("transform");
            
            transformMatrix = transformMatrix.mTranslate(340f, 340f);
            transformMatrix = transformMatrix.mRotate(direction);
            transformMatrix = transformMatrix.mTranslate(-340f, -340f);
            arrow.setMatrixTrait("transform", transformMatrix);
            // update text
            String dist = distance+"";
            if (distance > 0.9) {
                dist = dist.substring(0, Math.min(4, dist.length()))+"km";
            } else {
                dist = Math.ceil(distance*1000)+"m";
            }
            SVGElement text = (SVGElement) i.getDocument().getElementById("distanceValue");
            text.setTrait("#text", dist);
            System.out.println("Update distance "+distance);
        
        }
    }

    public void notifyIncomingMessage(MessageConnection conn) {
        //  Dispatch a single-pass message processor for each 
        //  incoming message.
        MessageReceiver mp = new MessageReceiver (conn, true);
    }

}
