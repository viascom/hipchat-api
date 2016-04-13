package ch.viascom.hipchat.api.models;

import lombok.Data;

/**
 * Created by patrickboesch on 12.04.16.
 */
@Data
public class Member {
    private String mention_name;
    private String version;
    private int id;
    private String name;

}
