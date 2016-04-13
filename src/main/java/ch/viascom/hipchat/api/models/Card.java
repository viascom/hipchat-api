package ch.viascom.hipchat.api.models;

import ch.viascom.hipchat.api.models.card.*;
import lombok.Data;

import java.util.ArrayList;

/**
 * Created by patrickboesch on 11.04.16.
 */
@Data
public class Card {
    private CardStyle style;
    private CardDescription description;
    private CardFormat format;
    private String url;
    private String title;
    private CardThumbnail thumbnail;
    private CardActivity activity;
    private ArrayList<CardAttribute> attributes = new ArrayList<>();
    private String id;
    private CardIcon icon;
}
