package game.controller;

import game.model.Background;
import game.model.Model;
import game.model.DataInfo;
import game.model.Score;
import game.model.objects.OwnPlane;

import java.util.List;

public class DataForView {
    Model model;

    public DataForView(Model model) {
        this.model = model;
    }

    public List<DataInfo> getAlienPlanes() {
        return model.getAliensDataInfos();
    }

    public DataInfo getOwnPlaneInfo() {
        OwnPlane ownPlain = model.getOwnPlain();
        return ownPlain.getDataInfo();
    }

    public List<Background> getBackground() {
        return model.getBackrounds();
    }

    public Score getScore() {
        return model.getScore();
    }


}
