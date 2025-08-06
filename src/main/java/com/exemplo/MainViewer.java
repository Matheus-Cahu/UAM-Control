//Arquivo principal
package com.exemplo;
import javax.swing.*;
import com.exemplo.Overlays.*;
import com.exemplo.Elements.*;
import java.util.List;
import java.util.Arrays;

import org.jxmapviewer.JXMapViewer;

public class MainViewer{
  public static void main(String[] args) {
    JFrame frame = new JFrame("MainViewer");
    frame.setSize(1280, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    OSMViewer mapPanel = new OSMViewer();

    frame.add(mapPanel);
    frame.setVisible(true);
}
}
