package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() throws HeadlessException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void init() {
        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }

    public void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);

        getContentPane().add(menuBar, BorderLayout.NORTH);

    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane htmlScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", htmlScrollPane);
        JScrollPane textScrollPane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", textScrollPane);

        tabbedPane.setPreferredSize(new Dimension(1000, 800));

        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void exit() {
        controller.exit();
    }

    public void selectedTabChanged() {
        int selectedIndex = tabbedPane.getSelectedIndex();
        if (selectedIndex == 0) {
            controller.setPlainText(plainTextPane.getText());
        } else if (selectedIndex == 1) {
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public Controller getController() {
        return controller;
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void undo() {
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout() {
        String message = "HTML Editor v0.1\r\n" +
                "developed by Vitaly Chura for JavaRush\r\n" +
                "@task3209";
        String title = "ShowAbout";
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
