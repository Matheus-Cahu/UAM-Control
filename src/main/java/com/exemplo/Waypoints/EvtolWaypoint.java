package com.exemplo;

import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import com.exemplo.Elements.*;

public class EvtolWaypoint extends DefaultWaypoint {
  private final Evtol evtol;

  public EvtolWaypoint(Evtol evtol){
    super(new GeoPosition(evtol.getLatitude(), evtol.getLongitude()));
    this.evtol = evtol;
  }

  public Evtol getEvtol(){
    return this.evtol;

  }

}
