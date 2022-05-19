package pers.zhangyang.easypvp.yaml;

import org.bukkit.Material;
import pers.zhangyang.easypvp.base.YamlManagerBase;

import java.util.ArrayList;
import java.util.List;

public class GuiYaml extends YamlManagerBase {
    public static GuiYaml GUI_MANAGER =new GuiYaml();
    private GuiYaml( ) {
        super("language/"+ SettingYaml.SETTING_YAML_MANAGER.getLANGUAGE()+"/gui.yml");
    }




    private String TITLE_ALL_MEMBER_PAGE;
    private String TITLE_ALL_PARTY_PAGE;
    private String TITLE_ALL_MAP_PAGE;
    private String TITLE_ALL_RACE_PAGE;

    private String TITLE_SHOP_PAGE;

    private String BUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_MATERIAL;
    private String BUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_LORE;

    private String BUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_MATERIAL;
    private String BUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_LORE;


    private String BUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL;
    private String BUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_LORE;

    private String BUTTON_ALL_PARTY_PAGE_SHOW_SHOP_PAGE_MATERIAL;
    private String BUTTON_ALL_PARTY_PAGE_SHOW_SHOP_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_PARTY_PAGE_SHOW_SHOP_PAGE_LORE;



    private String BUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_MATERIAL;
    private String BUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_LORE;

    private String BUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_MATERIAL;
    private String BUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_LORE;


    private String BUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL;
    private String BUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_LORE;

    private String BUTTON_ALL_RACE_PAGE_WATCH_RACE_MATERIAL;
    private String BUTTON_ALL_RACE_PAGE_WATCH_RACE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_RACE_PAGE_WATCH_RACE_LORE;

    private String BUTTON_ALL_RACE_PAGE_UNWATCH_RACE_MATERIAL;
    private String BUTTON_ALL_RACE_PAGE_UNWATCH_RACE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_RACE_PAGE_UNWATCH_RACE_LORE;





    private String TITLE_STAR_RANK_PAGE;


    private String BUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_MATERIAL;
    private String BUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_LORE;

    private String BUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_MATERIAL;
    private String BUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_LORE;


    private String BUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL;
    private String BUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_LORE;

    private String BUTTON_STAR_RANK_PAGE_RECORD_MATERIAL;
    private String BUTTON_STAR_RANK_PAGE_RECORD_DISPLAY_NAME;
    private List<String> BUTTON_STAR_RANK_PAGE_RECORD_LORE;




    private String TITLE_ALL_KIT_PAGE;
    private String BUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_MATERIAL;
    private String BUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_LORE;

    private String BUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_MATERIAL;
    private String BUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_LORE;


    private String BUTTON_ALL_KIT_PAGE_CHOOSE_KIT_MATERIAL;
    private String BUTTON_ALL_KIT_PAGE_CHOOSE_KIT_DISPLAY_NAME;
    private List<String> BUTTON_ALL_KIT_PAGE_CHOOSE_KIT_LORE;

    private String BUTTON_ALL_PARTY_PAGE_PREVIOUS_ALL_PARTY_PAGE_MATERIAL;
    private String BUTTON_ALL_PARTY_PAGE_PREVIOUS_ALL_PARTY_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_PARTY_PAGE_PREVIOUS_ALL_PARTY_PAGE_LORE;

    private String BUTTON_ALL_PARTY_PAGE_NEXT_ALL_PARTY_PAGE_MATERIAL;
    private String BUTTON_ALL_PARTY_PAGE_NEXT_ALL_PARTY_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_PARTY_PAGE_NEXT_ALL_PARTY_PAGE_LORE;


    private String BUTTON_ALL_PARTY_PAGE_SHOW_ALL_RACE_PAGE_MATERIAL;
    private String BUTTON_ALL_PARTY_PAGE_SHOW_ALL_RACE_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_PARTY_PAGE_SHOW_ALL_RACE_PAGE_LORE;


    private String BUTTON_ALL_PARTY_PAGE_SHOW_RANK_PAGE_MATERIAL;
    private String BUTTON_ALL_PARTY_PAGE_SHOW_RANK_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_PARTY_PAGE_SHOW_RANK_PAGE_LORE;

    private String BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_MATERIAL;
    private String BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_DISPLAY_NAME;
    private List<String> BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_LORE;

    private String BUTTON_ALL_PARTY_PAGE_JOIN_PARTY_MATERIAL;
    private String BUTTON_ALL_PARTY_PAGE_JOIN_PARTY_DISPLAY_NAME;
    private List<String> BUTTON_ALL_PARTY_PAGE_JOIN_PARTY_LORE;

    private String BUTTON_ALL_PARTY_PAGE_SHOW_ALL_MEMBER_PAGE_MATERIAL;
    private String BUTTON_ALL_PARTY_PAGE_SHOW_ALL_MEMBER_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_PARTY_PAGE_SHOW_ALL_MEMBER_PAGE_LORE;

    private String BUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_MATERIAL;
    private String BUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_LORE;

    private String BUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_MATERIAL;
    private String BUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_LORE;

    private String BUTTON_ALL_MEMBER_PAGE_MEMBER_MATERIAL;
    private String BUTTON_ALL_MEMBER_PAGE_MEMBER_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MEMBER_PAGE_MEMBER_LORE;

    private String BUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_MATERIAL;
    private String BUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_LORE;

    private String BUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL;
    private String BUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_LORE;

    private String BUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_MATERIAL;
    private String BUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_LORE;

    private String BUTTON_ALL_MAP_PAGE_MATCH_MAP_MATERIAL;
    private String BUTTON_ALL_MAP_PAGE_MATCH_MAP_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MAP_PAGE_MATCH_MAP_LORE;

    private String BUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_MATERIAL;
    private String BUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_LORE;

    private String BUTTON_ALL_MAP_PAGE_CANCEL_MATCH_MATERIAL;
    private String BUTTON_ALL_MAP_PAGE_CANCEL_MATCH_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MAP_PAGE_CANCEL_MATCH_LORE;

    private String BUTTON_ALL_MAP_PAGE_MATCH_RANDOM_MATERIAL;
    private String BUTTON_ALL_MAP_PAGE_MATCH_RANDOM_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MAP_PAGE_MATCH_RANDOM_LORE;


    public String getBUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_MATERIAL() {
        return BUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_MATERIAL;
    }

    public String getBUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_DISPLAY_NAME() {
        return BUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_LORE() {
       if (BUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_LORE==null) {
           return null;
       }
           return new ArrayList<>(BUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_LORE);
    }

    public String getBUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_MATERIAL() {
        return BUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_MATERIAL;
    }

    public String getBUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_DISPLAY_NAME() {
        return BUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_LORE() {
        if (BUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_LORE==null) {
            return null;
        }
        return new ArrayList<>(BUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_LORE);
    }

    public String getBUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL() {
        return BUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL;
    }

    public String getBUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME() {
        return BUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_LORE() {
        if (BUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_LORE==null) {
            return null;
        }
        return new ArrayList<>(BUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_LORE);
    }

    public String getBUTTON_ALL_PARTY_PAGE_SHOW_SHOP_PAGE_MATERIAL() {
        return BUTTON_ALL_PARTY_PAGE_SHOW_SHOP_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_PARTY_PAGE_SHOW_SHOP_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_PARTY_PAGE_SHOW_SHOP_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_PARTY_PAGE_SHOW_SHOP_PAGE_LORE() {
        if (BUTTON_ALL_PARTY_PAGE_SHOW_SHOP_PAGE_LORE==null) {
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_PARTY_PAGE_SHOW_SHOP_PAGE_LORE);  }

    public String getTITLE_SHOP_PAGE() {
        return TITLE_SHOP_PAGE;
    }

    @Override
    protected void check()   {
        TITLE_ALL_PARTY_PAGE=getString("gui.title.allPartyPage",false);

        TITLE_ALL_MAP_PAGE=getString("gui.title.allMapPage",false);
        TITLE_ALL_MEMBER_PAGE=getString("gui.title.allMemberPage",false);
        TITLE_ALL_KIT_PAGE=getString("gui.title.allKitPage",false);

        TITLE_ALL_RACE_PAGE=getString("gui.title.allRacePage",false);
        TITLE_SHOP_PAGE=getString("gui.title.shopPage",false);

        TITLE_STAR_RANK_PAGE =getString("gui.title.winRankPage",false);
        BUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_DISPLAY_NAME =getString("gui.button.allKitPagePreviousAllKitPage.displayName",false);
        BUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_MATERIAL =getString("gui.button.allKitPagePreviousAllKitPage.material",true);
        Material material=Material.matchMaterial(BUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_LORE =getStringList("gui.button.allKitPagePreviousAllKitPage.lore",false);

        BUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_DISPLAY_NAME =getString("gui.button.allKitPageNextAllKitPage.displayName",false);
        BUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_MATERIAL =getString("gui.button.allKitPageNextAllKitPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_LORE =getStringList("gui.button.allKitPageNextAllKitPage.lore",false);

        BUTTON_ALL_KIT_PAGE_CHOOSE_KIT_DISPLAY_NAME =getString("gui.button.allKitPageChooseKit.displayName",false);
        BUTTON_ALL_KIT_PAGE_CHOOSE_KIT_MATERIAL =getString("gui.button.allKitPageChooseKit.material",true);
        material=Material.matchMaterial(BUTTON_ALL_KIT_PAGE_CHOOSE_KIT_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_KIT_PAGE_CHOOSE_KIT_MATERIAL ="STONE";
        }
        BUTTON_ALL_KIT_PAGE_CHOOSE_KIT_LORE =getStringList("gui.button.allKitPageChooseKit.lore",false);


        BUTTON_ALL_PARTY_PAGE_PREVIOUS_ALL_PARTY_PAGE_DISPLAY_NAME =getString("gui.button.allPartyPagePreviousAllPartyPage.displayName",false);
        BUTTON_ALL_PARTY_PAGE_PREVIOUS_ALL_PARTY_PAGE_MATERIAL =getString("gui.button.allPartyPagePreviousAllPartyPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_PARTY_PAGE_PREVIOUS_ALL_PARTY_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_PARTY_PAGE_PREVIOUS_ALL_PARTY_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_PARTY_PAGE_PREVIOUS_ALL_PARTY_PAGE_LORE =getStringList("gui.button.allPartyPagePreviousAllPartyPage.lore",false);


        BUTTON_ALL_PARTY_PAGE_SHOW_RANK_PAGE_DISPLAY_NAME =getString("gui.button.allPartyPageShowRankPage.displayName",false);
        BUTTON_ALL_PARTY_PAGE_SHOW_RANK_PAGE_MATERIAL =getString("gui.button.allPartyPageShowRankPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_PARTY_PAGE_SHOW_RANK_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_PARTY_PAGE_SHOW_RANK_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_PARTY_PAGE_SHOW_RANK_PAGE_LORE =getStringList("gui.button.allPartyPageShowRankPage.lore",false);



        BUTTON_ALL_PARTY_PAGE_NEXT_ALL_PARTY_PAGE_DISPLAY_NAME =getString("gui.button.allPartyPageNextAllPartyPage.displayName",false);
        BUTTON_ALL_PARTY_PAGE_NEXT_ALL_PARTY_PAGE_MATERIAL =getString("gui.button.allPartyPageNextAllPartyPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_PARTY_PAGE_NEXT_ALL_PARTY_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_PARTY_PAGE_NEXT_ALL_PARTY_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_PARTY_PAGE_NEXT_ALL_PARTY_PAGE_LORE =getStringList("gui.button.allPartyPageNextAllPartyPage.lore",false);

        BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_DISPLAY_NAME =getString("gui.button.allPartyPageCreateParty.displayName",false);
        BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_MATERIAL =getString("gui.button.allPartyPageCreateParty.material",true);
        material=Material.matchMaterial(BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_MATERIAL ="STONE";
        }
        BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_LORE =getStringList("gui.button.allPartyPageCreateParty.lore",false);

        BUTTON_ALL_PARTY_PAGE_JOIN_PARTY_DISPLAY_NAME =getString("gui.button.allPartyPageJoinParty.displayName",false);
        BUTTON_ALL_PARTY_PAGE_JOIN_PARTY_MATERIAL =getString("gui.button.allPartyPageJoinParty.material",true);
        material=Material.matchMaterial(BUTTON_ALL_PARTY_PAGE_JOIN_PARTY_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_PARTY_PAGE_JOIN_PARTY_MATERIAL ="STONE";
        }
        BUTTON_ALL_PARTY_PAGE_JOIN_PARTY_LORE =getStringList("gui.button.allPartyPageJoinParty.lore",false);



        BUTTON_ALL_PARTY_PAGE_SHOW_ALL_MEMBER_PAGE_DISPLAY_NAME =getString("gui.button.allPartyPageShowAllMemberPage.displayName",false);
        BUTTON_ALL_PARTY_PAGE_SHOW_ALL_MEMBER_PAGE_MATERIAL =getString("gui.button.allPartyPageShowAllMemberPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_PARTY_PAGE_SHOW_ALL_MEMBER_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_PARTY_PAGE_SHOW_ALL_MEMBER_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_PARTY_PAGE_SHOW_ALL_MEMBER_PAGE_LORE =getStringList("gui.button.allPartyPageShowAllMemberPage.lore",false);

        BUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_DISPLAY_NAME =getString("gui.button.allMemberPagePreviousAllMemberPage.displayName",false);
        BUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_MATERIAL =getString("gui.button.allMemberPagePreviousAllMemberPage.material",true);
         material=Material.matchMaterial(BUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_LORE =getStringList("gui.button.allMemberPagePreviousAllMemberPage.lore",false);


        BUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_DISPLAY_NAME =getString("gui.button.allMemberPageNextAllMemberPage.displayName",false);
        BUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_MATERIAL =getString("gui.button.allMemberPageNextAllMemberPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_LORE =getStringList("gui.button.allMemberPageNextAllMemberPage.lore",false);

        BUTTON_ALL_MEMBER_PAGE_MEMBER_DISPLAY_NAME =getString("gui.button.allMemberPageMember.displayName",false);
        BUTTON_ALL_MEMBER_PAGE_MEMBER_MATERIAL =getString("gui.button.allMemberPageMember.material",true);
        material=Material.matchMaterial(BUTTON_ALL_MEMBER_PAGE_MEMBER_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MEMBER_PAGE_MEMBER_MATERIAL ="STONE";
        }
        BUTTON_ALL_MEMBER_PAGE_MEMBER_LORE =getStringList("gui.button.allMemberPageMember.lore",false);

        BUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_DISPLAY_NAME =getString("gui.button.allMemberPageShowAllMapPage.displayName",false);
        BUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_MATERIAL =getString("gui.button.allMemberPageShowAllMapPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_LORE =getStringList("gui.button.allMemberPageShowAllMapPage.lore",false);

        BUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME =getString("gui.button.allMemberPageBackAllPartyPage.displayName",false);
        BUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL =getString("gui.button.allMemberPageBackAllPartyPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_LORE =getStringList("gui.button.allMemberPageBackAllPartyPage.lore",false);

        BUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_DISPLAY_NAME =getString("gui.button.allMemberPageLeaveParty.displayName",false);
        BUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_MATERIAL =getString("gui.button.allMemberPageLeaveParty.material",true);
        material=Material.matchMaterial(BUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_MATERIAL ="STONE";
        }
        BUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_LORE =getStringList("gui.button.allMemberPageLeaveParty.lore",false);

        BUTTON_ALL_MAP_PAGE_MATCH_MAP_DISPLAY_NAME =getString("gui.button.allMapPageMatchMap.displayName",false);
        BUTTON_ALL_MAP_PAGE_MATCH_MAP_MATERIAL =getString("gui.button.allMapPageMatchMap.material",true);
        material=Material.matchMaterial(BUTTON_ALL_MAP_PAGE_MATCH_MAP_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MAP_PAGE_MATCH_MAP_MATERIAL ="STONE";
        }
        BUTTON_ALL_MAP_PAGE_MATCH_MAP_LORE =getStringList("gui.button.allMapPageMatchMap.lore",false);


        BUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_DISPLAY_NAME =getString("gui.button.allMapPageBackAllMemberPage.displayName",false);
        BUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_MATERIAL =getString("gui.button.allMapPageBackAllMemberPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_LORE =getStringList("gui.button.allMapPageBackAllMemberPage.lore",false);

        BUTTON_ALL_MAP_PAGE_CANCEL_MATCH_DISPLAY_NAME =getString("gui.button.allMapPageCancelMatch.displayName",false);
        BUTTON_ALL_MAP_PAGE_CANCEL_MATCH_MATERIAL =getString("gui.button.allMapPageCancelMatch.material",true);
        material=Material.matchMaterial(BUTTON_ALL_MAP_PAGE_CANCEL_MATCH_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MAP_PAGE_CANCEL_MATCH_MATERIAL ="STONE";
        }
        BUTTON_ALL_MAP_PAGE_CANCEL_MATCH_LORE =getStringList("gui.button.allMapPageCancelMatch.lore",false);

        BUTTON_ALL_MAP_PAGE_MATCH_RANDOM_DISPLAY_NAME =getString("gui.button.allMapPageMatchRandom.displayName",false);
        BUTTON_ALL_MAP_PAGE_MATCH_RANDOM_MATERIAL =getString("gui.button.allMapPageMatchRandom.material",true);
        material=Material.matchMaterial(BUTTON_ALL_MAP_PAGE_MATCH_RANDOM_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MAP_PAGE_MATCH_RANDOM_MATERIAL ="STONE";
        }
        BUTTON_ALL_MAP_PAGE_MATCH_RANDOM_LORE =getStringList("gui.button.allMapPageMatchRandom.lore",false);


        BUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME =getString("gui.button.starRankPageBackAllPartyPage.displayName",false);
        BUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL =getString("gui.button.starRankPageBackAllPartyPage.material",true);
        material=Material.matchMaterial(BUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL ="STONE";
        }
        BUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_LORE =getStringList("gui.button.starRankPageBackAllPartyPage.lore",false);

        BUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_DISPLAY_NAME =getString("gui.button.starRankPagePreviousRankPage.displayName",false);
        BUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_MATERIAL =getString("gui.button.starRankPagePreviousRankPage.material",true);
        material=Material.matchMaterial(BUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_MATERIAL ="STONE";
        }
        BUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_LORE =getStringList("gui.button.starRankPagePreviousRankPage.lore",false);


        BUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_DISPLAY_NAME =getString("gui.button.starRankPageNextRankPage.displayName",false);
        BUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_MATERIAL =getString("gui.button.starRankPageNextRankPage.material",true);
        material=Material.matchMaterial(BUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_MATERIAL ="STONE";
        }
        BUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_LORE =getStringList("gui.button.starRankPageNextRankPage.lore",false);

        BUTTON_STAR_RANK_PAGE_RECORD_DISPLAY_NAME =getString("gui.button.starRankPageRecord.displayName",false);
        BUTTON_STAR_RANK_PAGE_RECORD_MATERIAL =getString("gui.button.starRankPageRecord.material",true);
        material=Material.matchMaterial(BUTTON_STAR_RANK_PAGE_RECORD_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_STAR_RANK_PAGE_RECORD_MATERIAL ="STONE";
        }
        BUTTON_STAR_RANK_PAGE_RECORD_LORE =getStringList("gui.button.starRankPageRecord.lore",false);



        BUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME =getString("gui.button.shopPageBackAllPartyPage.displayName",false);
        BUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL =getString("gui.button.shopPageBackAllPartyPage.material",true);
        material=Material.matchMaterial(BUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL ="STONE";
        }
        BUTTON_SHOP_PAGE_BACK_ALL_PARTY_PAGE_LORE =getStringList("gui.button.shopPageBackAllPartyPage.lore",false);

        BUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_DISPLAY_NAME =getString("gui.button.shopPagePreviousShopPage.displayName",false);
        BUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_MATERIAL =getString("gui.button.shopPagePreviousShopPage.material",true);
        material=Material.matchMaterial(BUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_MATERIAL ="STONE";
        }
        BUTTON_SHOP_PAGE_PREVIOUS_SHOP_PAGE_LORE =getStringList("gui.button.shopPagePreviousShopPage.lore",false);


        BUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_DISPLAY_NAME =getString("gui.button.shopPageNextShopPage.displayName",false);
        BUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_MATERIAL =getString("gui.button.shopPageNextShopPage.material",true);
        material=Material.matchMaterial(BUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_MATERIAL ="STONE";
        }
        BUTTON_SHOP_PAGE_NEXT_SHOP_PAGE_LORE =getStringList("gui.button.shopPageNextShopPage.lore",false);

        BUTTON_ALL_PARTY_PAGE_SHOW_SHOP_PAGE_DISPLAY_NAME =getString("gui.button.allPartyPageShowShopPage.displayName",false);
        BUTTON_ALL_PARTY_PAGE_SHOW_SHOP_PAGE_MATERIAL =getString("gui.button.allPartyPageShowShopPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_PARTY_PAGE_SHOW_SHOP_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_PARTY_PAGE_SHOW_SHOP_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_PARTY_PAGE_SHOW_SHOP_PAGE_LORE =getStringList("gui.button.allPartyPageShowShopPage.lore",false);






        BUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME =getString("gui.button.allRacePageBackAllPartyPage.displayName",false);
        BUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL =getString("gui.button.allRacePageBackAllPartyPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_LORE =getStringList("gui.button.allRacePageBackAllPartyPage.lore",false);

        BUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_DISPLAY_NAME =getString("gui.button.allRacePagePreviousAllRacePage.displayName",false);
        BUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_MATERIAL =getString("gui.button.allRacePagePreviousAllRacePage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_LORE =getStringList("gui.button.allRacePagePreviousAllRacePage.lore",false);


        BUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_DISPLAY_NAME =getString("gui.button.allRacePageNextAllRacePage.displayName",false);
        BUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_MATERIAL =getString("gui.button.allRacePageNextAllRacePage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_LORE =getStringList("gui.button.allRacePageNextAllRacePage.lore",false);

        BUTTON_ALL_RACE_PAGE_WATCH_RACE_DISPLAY_NAME =getString("gui.button.allRacePageWatchRace.displayName",false);
        BUTTON_ALL_RACE_PAGE_WATCH_RACE_MATERIAL =getString("gui.button.allRacePageWatchRace.material",true);
        material=Material.matchMaterial(BUTTON_ALL_RACE_PAGE_WATCH_RACE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_RACE_PAGE_WATCH_RACE_MATERIAL ="STONE";
        }
        BUTTON_ALL_RACE_PAGE_WATCH_RACE_LORE =getStringList("gui.button.allRacePageWatchRace.lore",false);

        BUTTON_ALL_PARTY_PAGE_SHOW_ALL_RACE_PAGE_DISPLAY_NAME =getString("gui.button.allPartyPageShowAllRacePage.displayName",false);
        BUTTON_ALL_PARTY_PAGE_SHOW_ALL_RACE_PAGE_MATERIAL =getString("gui.button.allPartyPageShowAllRacePage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_PARTY_PAGE_SHOW_ALL_RACE_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_PARTY_PAGE_SHOW_ALL_RACE_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_PARTY_PAGE_SHOW_ALL_RACE_PAGE_LORE =getStringList("gui.button.allPartyPageShowAllRacePage.lore",false);

        BUTTON_ALL_RACE_PAGE_UNWATCH_RACE_DISPLAY_NAME =getString("gui.button.allRacePageUnwatchRace.displayName",false);
        BUTTON_ALL_RACE_PAGE_UNWATCH_RACE_MATERIAL =getString("gui.button.allRacePageUnwatchRace.material",true);
        material=Material.matchMaterial(BUTTON_ALL_RACE_PAGE_UNWATCH_RACE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_RACE_PAGE_UNWATCH_RACE_MATERIAL ="STONE";
        }
        BUTTON_ALL_RACE_PAGE_UNWATCH_RACE_LORE =getStringList("gui.button.allRacePageUnwatchRace.lore",false);

    }

    public String getBUTTON_ALL_RACE_PAGE_UNWATCH_RACE_MATERIAL() {
        return BUTTON_ALL_RACE_PAGE_UNWATCH_RACE_MATERIAL;
    }

    public String getBUTTON_ALL_RACE_PAGE_UNWATCH_RACE_DISPLAY_NAME() {
        return BUTTON_ALL_RACE_PAGE_UNWATCH_RACE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_RACE_PAGE_UNWATCH_RACE_LORE() {
        if (BUTTON_ALL_RACE_PAGE_UNWATCH_RACE_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_RACE_PAGE_UNWATCH_RACE_LORE);
    }

    public String getBUTTON_ALL_PARTY_PAGE_SHOW_ALL_RACE_PAGE_MATERIAL() {
        return BUTTON_ALL_PARTY_PAGE_SHOW_ALL_RACE_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_PARTY_PAGE_SHOW_ALL_RACE_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_PARTY_PAGE_SHOW_ALL_RACE_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_PARTY_PAGE_SHOW_ALL_RACE_PAGE_LORE() {
        if (BUTTON_ALL_PARTY_PAGE_SHOW_ALL_RACE_PAGE_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_PARTY_PAGE_SHOW_ALL_RACE_PAGE_LORE);
    }

    public String getTITLE_ALL_RACE_PAGE() {
        return TITLE_ALL_RACE_PAGE;
    }

    public String getBUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_MATERIAL() {
        return BUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_LORE() {
        if (BUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_LORE ==null){
            return null;
        }return new ArrayList<>(BUTTON_ALL_RACE_PAGE_PREVIOUS_ALL_RACE_PAGE_LORE);
    }

    public String getBUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_MATERIAL() {
        return BUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_LORE() {
        if (BUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_LORE ==null){
            return null;
        }return new ArrayList<>(BUTTON_ALL_RACE_PAGE_NEXT_ALL_RACE_PAGE_LORE);
    }

    public String getBUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL() {
        return BUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_LORE() {
        if (BUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_LORE==null){
            return null;
        }return new ArrayList<>(BUTTON_ALL_RACE_PAGE_BACK_ALL_PARTY_PAGE_LORE);
    }

    public String getBUTTON_ALL_RACE_PAGE_WATCH_RACE_MATERIAL() {
        return BUTTON_ALL_RACE_PAGE_WATCH_RACE_MATERIAL;
    }

    public String getBUTTON_ALL_RACE_PAGE_WATCH_RACE_DISPLAY_NAME() {
        return BUTTON_ALL_RACE_PAGE_WATCH_RACE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_RACE_PAGE_WATCH_RACE_LORE() {
        if (BUTTON_ALL_RACE_PAGE_WATCH_RACE_LORE==null){
            return null;
        }return new ArrayList<>(BUTTON_ALL_RACE_PAGE_WATCH_RACE_LORE);
    }






    public String getBUTTON_ALL_PARTY_PAGE_SHOW_RANK_PAGE_MATERIAL() {
        return BUTTON_ALL_PARTY_PAGE_SHOW_RANK_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_PARTY_PAGE_SHOW_RANK_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_PARTY_PAGE_SHOW_RANK_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_PARTY_PAGE_SHOW_RANK_PAGE_LORE() {
        if (BUTTON_ALL_PARTY_PAGE_SHOW_RANK_PAGE_LORE ==null){
            return null;
        }return new ArrayList<>(BUTTON_ALL_PARTY_PAGE_SHOW_RANK_PAGE_LORE);
    }

    public String getTITLE_STAR_RANK_PAGE() {
        return TITLE_STAR_RANK_PAGE;
    }

    public String getBUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_MATERIAL() {
        return BUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_MATERIAL;
    }

    public String getBUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_DISPLAY_NAME() {
        return BUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_LORE() {
        if (BUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_LORE ==null){
            return null;
        }return new ArrayList<>(BUTTON_STAR_RANK_PAGE_PREVIOUS_RANK_PAGE_LORE);
    }

    public String getBUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_MATERIAL() {
        return BUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_MATERIAL;
    }

    public String getBUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_DISPLAY_NAME() {
        return BUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_LORE() {
        if (BUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_LORE ==null){
            return null;
        }return new ArrayList<>(BUTTON_STAR_RANK_PAGE_NEXT_RANK_PAGE_LORE);
    }

    public String getBUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL() {
        return BUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL;
    }

    public String getBUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME() {
        return BUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_LORE() {
        if (BUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_LORE ==null){
            return null;
        }return new ArrayList<>(BUTTON_STAR_RANK_PAGE_BACK_ALL_PARTY_PAGE_LORE);
    }

    public String getBUTTON_STAR_RANK_PAGE_RECORD_MATERIAL() {
        return BUTTON_STAR_RANK_PAGE_RECORD_MATERIAL;
    }

    public String getBUTTON_STAR_RANK_PAGE_RECORD_DISPLAY_NAME() {
        return BUTTON_STAR_RANK_PAGE_RECORD_DISPLAY_NAME;
    }

    public List<String> getBUTTON_STAR_RANK_PAGE_RECORD_LORE() {
        if (BUTTON_STAR_RANK_PAGE_RECORD_LORE ==null){
            return null;
        }return new ArrayList<>(BUTTON_STAR_RANK_PAGE_RECORD_LORE);
    }

    public String getTITLE_ALL_KIT_PAGE() {
        return TITLE_ALL_KIT_PAGE;
    }

    public String getBUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_MATERIAL() {
        return BUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_LORE() {
        if (BUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_LORE ==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_KIT_PAGE_PREVIOUS_ALL_KIT_PAGE_LORE);
    }

    public String getBUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_MATERIAL() {
        return BUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_LORE() {
        if (BUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_LORE ==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_KIT_PAGE_NEXT_ALL_KIT_PAGE_LORE);
    }

    public String getBUTTON_ALL_KIT_PAGE_CHOOSE_KIT_MATERIAL() {
        return BUTTON_ALL_KIT_PAGE_CHOOSE_KIT_MATERIAL;
    }

    public String getBUTTON_ALL_KIT_PAGE_CHOOSE_KIT_DISPLAY_NAME() {
        return BUTTON_ALL_KIT_PAGE_CHOOSE_KIT_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_KIT_PAGE_CHOOSE_KIT_LORE() {
        if (BUTTON_ALL_KIT_PAGE_CHOOSE_KIT_LORE ==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_KIT_PAGE_CHOOSE_KIT_LORE);
    }

    public String getBUTTON_ALL_MAP_PAGE_MATCH_RANDOM_MATERIAL() {
        return BUTTON_ALL_MAP_PAGE_MATCH_RANDOM_MATERIAL;
    }

    public String getBUTTON_ALL_MAP_PAGE_MATCH_RANDOM_DISPLAY_NAME() {
        return BUTTON_ALL_MAP_PAGE_MATCH_RANDOM_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_MAP_PAGE_MATCH_RANDOM_LORE() {
        if (BUTTON_ALL_MAP_PAGE_MATCH_RANDOM_LORE ==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_MAP_PAGE_MATCH_RANDOM_LORE);
    }

    public String getBUTTON_ALL_MAP_PAGE_CANCEL_MATCH_MATERIAL() {
        return BUTTON_ALL_MAP_PAGE_CANCEL_MATCH_MATERIAL;
    }

    public String getBUTTON_ALL_MAP_PAGE_CANCEL_MATCH_DISPLAY_NAME() {
        return BUTTON_ALL_MAP_PAGE_CANCEL_MATCH_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_MAP_PAGE_CANCEL_MATCH_LORE() {
        if (BUTTON_ALL_MAP_PAGE_CANCEL_MATCH_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_MAP_PAGE_CANCEL_MATCH_LORE);
    }

    public String getBUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_MATERIAL() {
        return BUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_LORE() {
        if (BUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_LORE);
    }

    public String getTITLE_ALL_MAP_PAGE() {
        return TITLE_ALL_MAP_PAGE;
    }

    public String getBUTTON_ALL_MAP_PAGE_MATCH_MAP_MATERIAL() {
        return BUTTON_ALL_MAP_PAGE_MATCH_MAP_MATERIAL;
    }

    public String getBUTTON_ALL_MAP_PAGE_MATCH_MAP_DISPLAY_NAME() {
        return BUTTON_ALL_MAP_PAGE_MATCH_MAP_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_MAP_PAGE_MATCH_MAP_LORE() {
        if (BUTTON_ALL_MAP_PAGE_MATCH_MAP_LORE ==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_MAP_PAGE_MATCH_MAP_LORE);
    }

    public String getBUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL() {
        return BUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_LORE() {
        if (BUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_LORE);
    }

    public String getBUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_MATERIAL() {
        return BUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_MATERIAL;
    }

    public String getBUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_DISPLAY_NAME() {
        return BUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_LORE() {
        if (BUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_LORE);
    }

    public String getBUTTON_ALL_MEMBER_PAGE_MEMBER_MATERIAL() {
        return BUTTON_ALL_MEMBER_PAGE_MEMBER_MATERIAL;
    }

    public String getBUTTON_ALL_MEMBER_PAGE_MEMBER_DISPLAY_NAME() {
        return BUTTON_ALL_MEMBER_PAGE_MEMBER_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_MEMBER_PAGE_MEMBER_LORE() {
        if (BUTTON_ALL_MEMBER_PAGE_MEMBER_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_MEMBER_PAGE_MEMBER_LORE);
    }

    public String getBUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_MATERIAL() {
        return BUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_LORE() {
        if (BUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_LORE ==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_MEMBER_PAGE_SHOW_ALL_MAP_PAGE_LORE);
    }

    public String getTITLE_ALL_MEMBER_PAGE() {
        return TITLE_ALL_MEMBER_PAGE;
    }

    public String getBUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_MATERIAL() {
        return BUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_LORE() {
        if (BUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_LORE ==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_MEMBER_PAGE_PREVIOUS_ALL_MEMBER_PAGE_LORE);
    }

    public String getBUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_MATERIAL() {
        return BUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_LORE() {
        if (BUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_LORE ==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_MEMBER_PAGE_NEXT_ALL_MEMBER_PAGE_LORE);
    }

    public String getBUTTON_ALL_PARTY_PAGE_SHOW_ALL_MEMBER_PAGE_MATERIAL() {
        return BUTTON_ALL_PARTY_PAGE_SHOW_ALL_MEMBER_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_PARTY_PAGE_SHOW_ALL_MEMBER_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_PARTY_PAGE_SHOW_ALL_MEMBER_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_PARTY_PAGE_SHOW_ALL_MEMBER_PAGE_LORE() {
        if (BUTTON_ALL_PARTY_PAGE_SHOW_ALL_MEMBER_PAGE_LORE ==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_PARTY_PAGE_SHOW_ALL_MEMBER_PAGE_LORE);
    }

    public String getBUTTON_ALL_PARTY_PAGE_JOIN_PARTY_MATERIAL() {
        return BUTTON_ALL_PARTY_PAGE_JOIN_PARTY_MATERIAL;
    }

    public String getBUTTON_ALL_PARTY_PAGE_JOIN_PARTY_DISPLAY_NAME() {
        return BUTTON_ALL_PARTY_PAGE_JOIN_PARTY_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_PARTY_PAGE_JOIN_PARTY_LORE() {
        if (BUTTON_ALL_PARTY_PAGE_JOIN_PARTY_LORE ==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_PARTY_PAGE_JOIN_PARTY_LORE);
    }

    public String getBUTTON_ALL_PARTY_PAGE_NEXT_ALL_PARTY_PAGE_MATERIAL() {
        return BUTTON_ALL_PARTY_PAGE_NEXT_ALL_PARTY_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_PARTY_PAGE_NEXT_ALL_PARTY_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_PARTY_PAGE_NEXT_ALL_PARTY_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_PARTY_PAGE_NEXT_ALL_PARTY_PAGE_LORE() {
        if (BUTTON_ALL_PARTY_PAGE_NEXT_ALL_PARTY_PAGE_LORE ==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_PARTY_PAGE_NEXT_ALL_PARTY_PAGE_LORE);
    }

    public String getBUTTON_ALL_PARTY_PAGE_CREATE_PARTY_MATERIAL() {
        return BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_MATERIAL;
    }

    public String getBUTTON_ALL_PARTY_PAGE_CREATE_PARTY_DISPLAY_NAME() {
        return BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_PARTY_PAGE_CREATE_PARTY_LORE() {
        if (BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_LORE);
    }

    public static GuiYaml getGuiManager() {
        return GUI_MANAGER;
    }

    public String getBUTTON_ALL_PARTY_PAGE_PREVIOUS_ALL_PARTY_PAGE_MATERIAL() {
        return BUTTON_ALL_PARTY_PAGE_PREVIOUS_ALL_PARTY_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_PARTY_PAGE_PREVIOUS_ALL_PARTY_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_PARTY_PAGE_PREVIOUS_ALL_PARTY_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_PARTY_PAGE_PREVIOUS_ALL_PARTY_PAGE_LORE() {
        if (BUTTON_ALL_PARTY_PAGE_PREVIOUS_ALL_PARTY_PAGE_LORE ==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_PARTY_PAGE_PREVIOUS_ALL_PARTY_PAGE_LORE);
    }

    public String getTITLE_ALL_PARTY_PAGE() {
        return TITLE_ALL_PARTY_PAGE;
    }
}
