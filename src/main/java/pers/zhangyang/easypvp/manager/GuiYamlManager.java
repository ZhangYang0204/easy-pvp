package pers.zhangyang.easypvp.manager;

import org.bukkit.Material;
import pers.zhangyang.easypvp.base.YamlManagerBase;

import java.util.ArrayList;
import java.util.List;

public class GuiYamlManager extends YamlManagerBase {
    public static GuiYamlManager GUI_MANAGER =new GuiYamlManager();
    private GuiYamlManager( ) {
        super("language/"+SettingYamlManager.SETTING_YAML_MANAGER.getLANGUAGE()+"/gui.yml");
    }


    private String TITLE_ALL_MEMBER_PAGE;
    private String TITLE_ALL_PARTY_PAGE;
    private String TITLE_ALL_MAP_PAGE;



    private String TITLE_RANK_PAGE;


    private String BUTTON_RANK_PAGE_PREVIOUS_PAGE_MATERIAL;
    private String BUTTON_RANK_PAGE_PREVIOUS_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_RANK_PAGE_PREVIOUS_PAGE_LORE;

    private String BUTTON_RANK_PAGE_NEXT_PAGE_MATERIAL;
    private String BUTTON_RANK_PAGE_NEXT_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_RANK_PAGE_NEXT_PAGE_LORE;


    private String BUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL;
    private String BUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_LORE;

    private String BUTTON_RANK_PAGE_RECORD_MATERIAL;
    private String BUTTON_RANK_PAGE_RECORD_DISPLAY_NAME;
    private List<String> BUTTON_RANK_PAGE_RECORD_LORE;




    private String TITLE_ALL_KIT_PAGE;
    private String BUTTON_ALL_KIT_PAGE_PREVIOUS_PAGE_MATERIAL;
    private String BUTTON_ALL_KIT_PAGE_PREVIOUS_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_KIT_PAGE_PREVIOUS_PAGE_LORE;

    private String BUTTON_ALL_KIT_PAGE_NEXT_PAGE_MATERIAL;
    private String BUTTON_ALL_KIT_PAGE_NEXT_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_KIT_PAGE_NEXT_PAGE_LORE;


    private String BUTTON_ALL_KIT_PAGE_KIT_MATERIAL;
    private String BUTTON_ALL_KIT_PAGE_KIT_DISPLAY_NAME;
    private List<String> BUTTON_ALL_KIT_PAGE_KIT_LORE;

    private String BUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_MATERIAL;
    private String BUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_LORE;

    private String BUTTON_ALL_PARTY_PAGE_NEXT_PAGE_MATERIAL;
    private String BUTTON_ALL_PARTY_PAGE_NEXT_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_PARTY_PAGE_NEXT_PAGE_LORE;


    private String BUTTON_ALL_PARTY_PAGE_RANK_PAGE_MATERIAL;
    private String BUTTON_ALL_PARTY_PAGE_RANK_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_PARTY_PAGE_RANK_PAGE_LORE;

    private String BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_MATERIAL;
    private String BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_DISPLAY_NAME;
    private List<String> BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_LORE;

    private String BUTTON_ALL_PARTY_PAGE_PARTY_MATERIAL;
    private String BUTTON_ALL_PARTY_PAGE_PARTY_DISPLAY_NAME;
    private List<String> BUTTON_ALL_PARTY_PAGE_PARTY_LORE;

    private String BUTTON_ALL_PARTY_PAGE_MY_PARTY_MATERIAL;
    private String BUTTON_ALL_PARTY_PAGE_MY_PARTY_DISPLAY_NAME;
    private List<String> BUTTON_ALL_PARTY_PAGE_MY_PARTY_LORE;

    private String BUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_MATERIAL;
    private String BUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_LORE;

    private String BUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_MATERIAL;
    private String BUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_LORE;

    private String BUTTON_ALL_MEMBER_PAGE_MEMBER_MATERIAL;
    private String BUTTON_ALL_MEMBER_PAGE_MEMBER_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MEMBER_PAGE_MEMBER_LORE;

    private String BUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_MATERIAL;
    private String BUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_LORE;

    private String BUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL;
    private String BUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MEMBER_PAGE_BACK_ALL_PARTY_PAGE_LORE;

    private String BUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_MATERIAL;
    private String BUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MEMBER_PAGE_LEAVE_PARTY_LORE;

    private String BUTTON_ALL_MAP_PAGE_MAP_MATERIAL;
    private String BUTTON_ALL_MAP_PAGE_MAP_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MAP_PAGE_MAP_LORE;

    private String BUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_MATERIAL;
    private String BUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MAP_PAGE_BACK_ALL_MEMBER_PAGE_LORE;

    private String BUTTON_ALL_MAP_PAGE_CANCEL_MATCH_MATERIAL;
    private String BUTTON_ALL_MAP_PAGE_CANCEL_MATCH_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MAP_PAGE_CANCEL_MATCH_LORE;

    private String BUTTON_ALL_MAP_PAGE_RANDOM_MATCH_MATERIAL;
    private String BUTTON_ALL_MAP_PAGE_RANDOM_MATCH_DISPLAY_NAME;
    private List<String> BUTTON_ALL_MAP_PAGE_RANDOM_MATCH_LORE;



    @Override
    protected void check()   {
        TITLE_ALL_PARTY_PAGE=getString("gui.title.allPartyPage",false);

        TITLE_ALL_MAP_PAGE=getString("gui.title.allMapPage",false);
        TITLE_ALL_MEMBER_PAGE=getString("gui.title.allMemberPage",false);
        TITLE_ALL_KIT_PAGE=getString("gui.title.allKitPage",false);


        TITLE_RANK_PAGE=getString("gui.title.rankPage",false);
        BUTTON_ALL_KIT_PAGE_PREVIOUS_PAGE_DISPLAY_NAME =getString("gui.button.allKitPagePreviousPage.displayName",false);
        BUTTON_ALL_KIT_PAGE_PREVIOUS_PAGE_MATERIAL =getString("gui.button.allKitPagePreviousPage.material",true);
        Material material=Material.matchMaterial(BUTTON_ALL_KIT_PAGE_PREVIOUS_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_KIT_PAGE_PREVIOUS_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_KIT_PAGE_PREVIOUS_PAGE_LORE =getStringList("gui.button.allKitPagePreviousPage.lore",false);

        BUTTON_ALL_KIT_PAGE_NEXT_PAGE_DISPLAY_NAME =getString("gui.button.allKitPageNextPage.displayName",false);
        BUTTON_ALL_KIT_PAGE_NEXT_PAGE_MATERIAL =getString("gui.button.allKitPageNextPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_KIT_PAGE_NEXT_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_KIT_PAGE_NEXT_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_KIT_PAGE_NEXT_PAGE_LORE =getStringList("gui.button.allKitPageNextPage.lore",false);

        BUTTON_ALL_KIT_PAGE_KIT_DISPLAY_NAME =getString("gui.button.allKitPageKit.displayName",false);
        BUTTON_ALL_KIT_PAGE_KIT_MATERIAL =getString("gui.button.allKitPageKit.material",true);
        material=Material.matchMaterial(BUTTON_ALL_KIT_PAGE_KIT_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_KIT_PAGE_KIT_MATERIAL ="STONE";
        }
        BUTTON_ALL_KIT_PAGE_KIT_LORE =getStringList("gui.button.allKitPageKit.lore",false);


        BUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_DISPLAY_NAME =getString("gui.button.allPartyPagePreviousPage.displayName",false);
        BUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_MATERIAL =getString("gui.button.allPartyPagePreviousPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_LORE =getStringList("gui.button.allPartyPagePreviousPage.lore",false);


        BUTTON_ALL_PARTY_PAGE_RANK_PAGE_DISPLAY_NAME =getString("gui.button.allPartyPageRankPage.displayName",false);
        BUTTON_ALL_PARTY_PAGE_RANK_PAGE_MATERIAL =getString("gui.button.allPartyPageRankPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_PARTY_PAGE_RANK_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_PARTY_PAGE_RANK_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_PARTY_PAGE_RANK_PAGE_LORE =getStringList("gui.button.allPartyPageRankPage.lore",false);



        BUTTON_ALL_PARTY_PAGE_NEXT_PAGE_DISPLAY_NAME =getString("gui.button.allPartyPageNextPage.displayName",false);
        BUTTON_ALL_PARTY_PAGE_NEXT_PAGE_MATERIAL =getString("gui.button.allPartyPageNextPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_PARTY_PAGE_NEXT_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_PARTY_PAGE_NEXT_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_PARTY_PAGE_NEXT_PAGE_LORE =getStringList("gui.button.allPartyPageNextPage.lore",false);

        BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_DISPLAY_NAME =getString("gui.button.allPartyPageCreateParty.displayName",false);
        BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_MATERIAL =getString("gui.button.allPartyPageCreateParty.material",true);
        material=Material.matchMaterial(BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_MATERIAL ="STONE";
        }
        BUTTON_ALL_PARTY_PAGE_CREATE_PARTY_LORE =getStringList("gui.button.allPartyPageCreateParty.lore",false);

        BUTTON_ALL_PARTY_PAGE_PARTY_DISPLAY_NAME =getString("gui.button.allPartyPageParty.displayName",false);
        BUTTON_ALL_PARTY_PAGE_PARTY_MATERIAL =getString("gui.button.allPartyPageParty.material",true);
        material=Material.matchMaterial(BUTTON_ALL_PARTY_PAGE_PARTY_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_PARTY_PAGE_PARTY_MATERIAL ="STONE";
        }
        BUTTON_ALL_PARTY_PAGE_PARTY_LORE =getStringList("gui.button.allPartyPageParty.lore",false);



        BUTTON_ALL_PARTY_PAGE_MY_PARTY_DISPLAY_NAME =getString("gui.button.allPartyPageMyParty.displayName",false);
        BUTTON_ALL_PARTY_PAGE_MY_PARTY_MATERIAL =getString("gui.button.allPartyPageMyParty.material",true);
        material=Material.matchMaterial(BUTTON_ALL_PARTY_PAGE_MY_PARTY_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_PARTY_PAGE_MY_PARTY_MATERIAL ="STONE";
        }
        BUTTON_ALL_PARTY_PAGE_MY_PARTY_LORE =getStringList("gui.button.allPartyPageMyParty.lore",false);

        BUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_DISPLAY_NAME =getString("gui.button.allMemberPagePreviousPage.displayName",false);
        BUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_MATERIAL =getString("gui.button.allMemberPagePreviousPage.material",true);
         material=Material.matchMaterial(BUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_LORE =getStringList("gui.button.allMemberPagePreviousPage.lore",false);


        BUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_DISPLAY_NAME =getString("gui.button.allMemberPageNextPage.displayName",false);
        BUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_MATERIAL =getString("gui.button.allMemberPageNextPage.material",true);
        material=Material.matchMaterial(BUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_MATERIAL ="STONE";
        }
        BUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_LORE =getStringList("gui.button.allMemberPagePreviousPage.lore",false);

        BUTTON_ALL_MEMBER_PAGE_MEMBER_DISPLAY_NAME =getString("gui.button.allMemberPageMember.displayName",false);
        BUTTON_ALL_MEMBER_PAGE_MEMBER_MATERIAL =getString("gui.button.allMemberPageMember.material",true);
        material=Material.matchMaterial(BUTTON_ALL_MEMBER_PAGE_MEMBER_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MEMBER_PAGE_MEMBER_MATERIAL ="STONE";
        }
        BUTTON_ALL_MEMBER_PAGE_MEMBER_LORE =getStringList("gui.button.allMemberPageMember.lore",false);

        BUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_DISPLAY_NAME =getString("gui.button.allMemberPageChooseMap.displayName",false);
        BUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_MATERIAL =getString("gui.button.allMemberPageChooseMap.material",true);
        material=Material.matchMaterial(BUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_MATERIAL ="STONE";
        }
        BUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_LORE =getStringList("gui.button.allMemberPageChooseMap.lore",false);

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

        BUTTON_ALL_MAP_PAGE_MAP_DISPLAY_NAME =getString("gui.button.allMapPageMap.displayName",false);
        BUTTON_ALL_MAP_PAGE_MAP_MATERIAL =getString("gui.button.allMapPageMap.material",true);
        material=Material.matchMaterial(BUTTON_ALL_MAP_PAGE_MAP_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MAP_PAGE_MAP_MATERIAL ="STONE";
        }
        BUTTON_ALL_MAP_PAGE_MAP_LORE =getStringList("gui.button.allMapPageMap.lore",false);


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

        BUTTON_ALL_MAP_PAGE_RANDOM_MATCH_DISPLAY_NAME =getString("gui.button.allMapPageRandomMatch.displayName",false);
        BUTTON_ALL_MAP_PAGE_RANDOM_MATCH_MATERIAL =getString("gui.button.allMapPageRandomMatch.material",true);
        material=Material.matchMaterial(BUTTON_ALL_MAP_PAGE_RANDOM_MATCH_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_ALL_MAP_PAGE_RANDOM_MATCH_MATERIAL ="STONE";
        }
        BUTTON_ALL_MAP_PAGE_RANDOM_MATCH_LORE =getStringList("gui.button.allMapPageRandomMatch.lore",false);


        BUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME =getString("gui.button.rankPageBackAllPartyPage.displayName",false);
        BUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL =getString("gui.button.rankPageBackAllPartyPage.material",true);
        material=Material.matchMaterial(BUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL ="STONE";
        }
        BUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_LORE =getStringList("gui.button.rankPageBackAllPartyPage.lore",false);

        BUTTON_RANK_PAGE_PREVIOUS_PAGE_DISPLAY_NAME =getString("gui.button.rankPagePreviousPage.displayName",false);
        BUTTON_RANK_PAGE_PREVIOUS_PAGE_MATERIAL =getString("gui.button.rankPagePreviousPage.material",true);
        material=Material.matchMaterial(BUTTON_RANK_PAGE_PREVIOUS_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_RANK_PAGE_PREVIOUS_PAGE_MATERIAL ="STONE";
        }
        BUTTON_RANK_PAGE_PREVIOUS_PAGE_LORE =getStringList("gui.button.rankPagePreviousPage.lore",false);


        BUTTON_RANK_PAGE_NEXT_PAGE_DISPLAY_NAME =getString("gui.button.rankPageNextPage.displayName",false);
        BUTTON_RANK_PAGE_NEXT_PAGE_MATERIAL =getString("gui.button.rankPageNextPage.material",true);
        material=Material.matchMaterial(BUTTON_RANK_PAGE_NEXT_PAGE_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_RANK_PAGE_NEXT_PAGE_MATERIAL ="STONE";
        }
        BUTTON_RANK_PAGE_NEXT_PAGE_LORE =getStringList("gui.button.rankPageNextPage.lore",false);

        BUTTON_RANK_PAGE_RECORD_DISPLAY_NAME =getString("gui.button.rankPageRecord.displayName",false);
        BUTTON_RANK_PAGE_RECORD_MATERIAL =getString("gui.button.rankPageRecord.material",true);
        material=Material.matchMaterial(BUTTON_RANK_PAGE_RECORD_MATERIAL);
        if (material==null||material.equals(Material.AIR)){
            BUTTON_RANK_PAGE_RECORD_MATERIAL ="STONE";
        }
        BUTTON_RANK_PAGE_RECORD_LORE =getStringList("gui.button.rankPageRecord.lore",false);


    }


    public String getBUTTON_ALL_PARTY_PAGE_RANK_PAGE_MATERIAL() {
        return BUTTON_ALL_PARTY_PAGE_RANK_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_PARTY_PAGE_RANK_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_PARTY_PAGE_RANK_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_PARTY_PAGE_RANK_PAGE_LORE() {
        if (BUTTON_ALL_PARTY_PAGE_RANK_PAGE_LORE==null){
            return null;
        }return new ArrayList<>(BUTTON_ALL_PARTY_PAGE_RANK_PAGE_LORE);
    }

    public String getTITLE_RANK_PAGE() {
        return TITLE_RANK_PAGE;
    }

    public String getBUTTON_RANK_PAGE_PREVIOUS_PAGE_MATERIAL() {
        return BUTTON_RANK_PAGE_PREVIOUS_PAGE_MATERIAL;
    }

    public String getBUTTON_RANK_PAGE_PREVIOUS_PAGE_DISPLAY_NAME() {
        return BUTTON_RANK_PAGE_PREVIOUS_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_RANK_PAGE_PREVIOUS_PAGE_LORE() {
        if (BUTTON_RANK_PAGE_PREVIOUS_PAGE_LORE==null){
            return null;
        }return new ArrayList<>(BUTTON_RANK_PAGE_PREVIOUS_PAGE_LORE);
    }

    public String getBUTTON_RANK_PAGE_NEXT_PAGE_MATERIAL() {
        return BUTTON_RANK_PAGE_NEXT_PAGE_MATERIAL;
    }

    public String getBUTTON_RANK_PAGE_NEXT_PAGE_DISPLAY_NAME() {
        return BUTTON_RANK_PAGE_NEXT_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_RANK_PAGE_NEXT_PAGE_LORE() {
        if (BUTTON_RANK_PAGE_NEXT_PAGE_LORE==null){
            return null;
        }return new ArrayList<>(BUTTON_RANK_PAGE_NEXT_PAGE_LORE);
    }

    public String getBUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL() {
        return BUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_MATERIAL;
    }

    public String getBUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME() {
        return BUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_LORE() {
        if (BUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_LORE==null){
            return null;
        }return new ArrayList<>(BUTTON_RANK_PAGE_BACK_ALL_PARTY_PAGE_LORE);
    }

    public String getBUTTON_RANK_PAGE_RECORD_MATERIAL() {
        return BUTTON_RANK_PAGE_RECORD_MATERIAL;
    }

    public String getBUTTON_RANK_PAGE_RECORD_DISPLAY_NAME() {
        return BUTTON_RANK_PAGE_RECORD_DISPLAY_NAME;
    }

    public List<String> getBUTTON_RANK_PAGE_RECORD_LORE() {
        if (BUTTON_RANK_PAGE_RECORD_LORE==null){
            return null;
        }return new ArrayList<>(BUTTON_RANK_PAGE_RECORD_LORE);
    }

    public String getTITLE_ALL_KIT_PAGE() {
        return TITLE_ALL_KIT_PAGE;
    }

    public String getBUTTON_ALL_KIT_PAGE_PREVIOUS_PAGE_MATERIAL() {
        return BUTTON_ALL_KIT_PAGE_PREVIOUS_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_KIT_PAGE_PREVIOUS_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_KIT_PAGE_PREVIOUS_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_KIT_PAGE_PREVIOUS_PAGE_LORE() {
        if (BUTTON_ALL_KIT_PAGE_PREVIOUS_PAGE_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_KIT_PAGE_PREVIOUS_PAGE_LORE);
    }

    public String getBUTTON_ALL_KIT_PAGE_NEXT_PAGE_MATERIAL() {
        return BUTTON_ALL_KIT_PAGE_NEXT_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_KIT_PAGE_NEXT_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_KIT_PAGE_NEXT_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_KIT_PAGE_NEXT_PAGE_LORE() {
        if (BUTTON_ALL_KIT_PAGE_NEXT_PAGE_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_KIT_PAGE_NEXT_PAGE_LORE);
    }

    public String getBUTTON_ALL_KIT_PAGE_KIT_MATERIAL() {
        return BUTTON_ALL_KIT_PAGE_KIT_MATERIAL;
    }

    public String getBUTTON_ALL_KIT_PAGE_KIT_DISPLAY_NAME() {
        return BUTTON_ALL_KIT_PAGE_KIT_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_KIT_PAGE_KIT_LORE() {
        if (BUTTON_ALL_KIT_PAGE_KIT_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_KIT_PAGE_KIT_LORE);
    }

    public String getBUTTON_ALL_MAP_PAGE_RANDOM_MATCH_MATERIAL() {
        return BUTTON_ALL_MAP_PAGE_RANDOM_MATCH_MATERIAL;
    }

    public String getBUTTON_ALL_MAP_PAGE_RANDOM_MATCH_DISPLAY_NAME() {
        return BUTTON_ALL_MAP_PAGE_RANDOM_MATCH_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_MAP_PAGE_RANDOM_MATCH_LORE() {
        if (BUTTON_ALL_MAP_PAGE_RANDOM_MATCH_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_MAP_PAGE_RANDOM_MATCH_LORE);
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

    public String getBUTTON_ALL_MAP_PAGE_MAP_MATERIAL() {
        return BUTTON_ALL_MAP_PAGE_MAP_MATERIAL;
    }

    public String getBUTTON_ALL_MAP_PAGE_MAP_DISPLAY_NAME() {
        return BUTTON_ALL_MAP_PAGE_MAP_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_MAP_PAGE_MAP_LORE() {
        if (BUTTON_ALL_MAP_PAGE_MAP_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_MAP_PAGE_MAP_LORE);
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

    public String getBUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_MATERIAL() {
        return BUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_MATERIAL;
    }

    public String getBUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_DISPLAY_NAME() {
        return BUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_LORE() {
        if (BUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_MEMBER_PAGE_CHOOSE_MAP_LORE);
    }

    public String getTITLE_ALL_MEMBER_PAGE() {
        return TITLE_ALL_MEMBER_PAGE;
    }

    public String getBUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_MATERIAL() {
        return BUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_LORE() {
        if (BUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_MEMBER_PAGE_PREVIOUS_PAGE_LORE);
    }

    public String getBUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_MATERIAL() {
        return BUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_LORE() {
        if (BUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_MEMBER_PAGE_NEXT_PAGE_LORE);
    }

    public String getBUTTON_ALL_PARTY_PAGE_MY_PARTY_MATERIAL() {
        return BUTTON_ALL_PARTY_PAGE_MY_PARTY_MATERIAL;
    }

    public String getBUTTON_ALL_PARTY_PAGE_MY_PARTY_DISPLAY_NAME() {
        return BUTTON_ALL_PARTY_PAGE_MY_PARTY_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_PARTY_PAGE_MY_PARTY_LORE() {
        if (BUTTON_ALL_PARTY_PAGE_MY_PARTY_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_PARTY_PAGE_MY_PARTY_LORE);
    }

    public String getBUTTON_ALL_PARTY_PAGE_PARTY_MATERIAL() {
        return BUTTON_ALL_PARTY_PAGE_PARTY_MATERIAL;
    }

    public String getBUTTON_ALL_PARTY_PAGE_PARTY_DISPLAY_NAME() {
        return BUTTON_ALL_PARTY_PAGE_PARTY_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_PARTY_PAGE_PARTY_LORE() {
        if (BUTTON_ALL_PARTY_PAGE_PARTY_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_PARTY_PAGE_PARTY_LORE);
    }

    public String getBUTTON_ALL_PARTY_PAGE_NEXT_PAGE_MATERIAL() {
        return BUTTON_ALL_PARTY_PAGE_NEXT_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_PARTY_PAGE_NEXT_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_PARTY_PAGE_NEXT_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_PARTY_PAGE_NEXT_PAGE_LORE() {
        if (BUTTON_ALL_PARTY_PAGE_NEXT_PAGE_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_PARTY_PAGE_NEXT_PAGE_LORE);
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

    public static GuiYamlManager getGuiManager() {
        return GUI_MANAGER;
    }

    public String getBUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_MATERIAL() {
        return BUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_MATERIAL;
    }

    public String getBUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_DISPLAY_NAME() {
        return BUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_DISPLAY_NAME;
    }

    public List<String> getBUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_LORE() {
        if (BUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_LORE==null){
            return null;
        }
        return new ArrayList<>(BUTTON_ALL_PARTY_PAGE_PREVIOUS_PAGE_LORE);
    }

    public String getTITLE_ALL_PARTY_PAGE() {
        return TITLE_ALL_PARTY_PAGE;
    }
}
