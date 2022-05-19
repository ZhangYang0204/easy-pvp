package pers.zhangyang.easypvp.yaml;

import pers.zhangyang.easypvp.base.YamlManagerBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageYaml extends YamlManagerBase {
    public static final MessageYaml MESSAGE_YAML_MANAGER =new MessageYaml();

    private MessageYaml( ) {
        super("language/"+ SettingYaml.SETTING_YAML_MANAGER.getLANGUAGE()+"/message.yml");
    }

    private List<String> CHAT_FAILURE_NOTIFY_VERSION_BECAUSE_NOT_GET_LATEST_VERSION;
    private String INPUT_CANCEL;
    private List<String> CHAT_NOT_PLAYER;
    private List<String> CHAT_NO_PERMISSION;

    private List<String> CHAT_SUCCESS_CORRECT_YAML;
    private List<String> CHAT_SUCCESS_RESET_SEASON;
    private List<String> CHAT_SUCCESS_RELOAD_YAML;
    private List<String> CHAT_SUCCESS_HELP;
    private List<String> CHAT_SUCCESS_CANCEL_CREATE_PARTY;
    private List<String> CHAT_SUCCESS_OPEN_GUI;
    private List<String> CHAT_SUCCESS_SET_SECTION;

    private HashMap<Integer,List<String>> CHAT_STREAK;

    private List<String> CHAT_SOMEONE_SUCCESS_DEAD_IN_RACING;
    private List<String> CHAT_SOMEONE_SUCCESS_MOVE_OUT_MAP;
    private List<String> CHAT_SUCCESS_DEAD_IN_RACING;
    

    private List<String> CHAT_INVALID_ARGUMENT;
    private List<String> CHAT_FAILURE_MAP_CREATE_BECAUSE_INVALID_FOUR_POINT;

    private List<String> CHAT_FAILURE_MAP_CREATE_BECAUSE_NOT_FOUR_POINT;
    private List<String> CHAT_SUCCESS_CREATE_MAP;

    private List<String> CHAT_FAILURE_JOIN_PARTY_BECAUSE_PARTY_IS_RACING;

    private List<String> CHAT_FAILURE_JOIN_PARTY_BECAUSE_IN_WATCHING;
    private List<String> CHAT_SUCCESS_DELETE_MAP;

    private List<String> CHAT_FAILURE_DELETE_MAP_BECAUSE_NOT_EXIST_MAP_NAME;
    private List<String> CHAT_FAILURE_CREATE_MAP_BECAUSE_DUPLICATE_MAP_NAME;

    private List<String> CHAT_SUCCESS_SET_MAP_CHOOSE_TIME;

    private List<String> CHAT_FAILURE_SET_MAP_CHOOSE_TIME_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_SUCCESS_ADD_MAP_DESCRIPTION;

    private List<String> CHAT_FAILURE_ADD_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_FAILURE_MAP_REMOVE_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_FAILURE_REMOVE_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW;

    private List<String> CHAT_SUCCESS_REMOVE_MAP_DESCRIPTION;

    private List<String> CHAT_FAILURE_SET_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_FAILURE_SET_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW;

    private List<String> CHAT_SUCCESS_SET_MAP_DESCRIPTION;

    private List<String> CHAT_SUCCESS_NOTIFY_VERSION;

    private List<String> CHAT_SUCCESS_SET_MAP_BUILD;
    private List<String> CHAT_SUCCESS_SET_MAP_FAIR;
    private List<String> CHAT_SUCCESS_SET_MAP_SCALE;
    private List<String> CHAT_SUCCESS_SET_MAP_KEEP_INVENTORY;

    private List<String> CHAT_SUCCESS_SET_MAP_KEEP_LEVEL;

    private List<String> CHAT_FAILURE_SET_MAP_KEEP_LEVEL_BECAUSE_NOT_EXIST_MAP_NAME;
    
    private List<String> CHAT_SUCCESS_LEAVE_PARTY;
    private List<String> CHAT_FAILURE_SET_MAP_FAIR_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_FAILURE_SET_MAP_BUILD_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_FAILURE_SET_MAP_KEEP_INVENTORY_BECAUSE_NOT_EXIST_MAP_NAME;
    private List<String> CHAT_FAILURE_SET_MAP_SCALE_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_SUCCESS_CREATE_KIT;

    private List<String> CHAT_FAILURE_CREATE_KIT_BECAUSE_DUPLICATE_KIT_NAME;

    private List<String> CHAT_SUCCESS_DELETE_KIT;

    private List<String> CHAT_FAILURE_DELETE_KIT_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_SUCCESS_SET_KIT;

    private List<String> CHAT_FAILURE_SET_KIT_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_SUCCESS_ADD_MAP_KIT;



    private List<String> CHAT_SUCCESS_NEXT_SHOP_PAGE;
    private List<String> CHAT_SUCCESS_PREVIOUS_SHOP_PAGE;
    private List<String> CHAT_FAILURE_NEXT_SHOP_PAGE_BECAUSE_NOT_NEXT;
    private List<String> CHAT_FAILURE_PREVIOUS_SHOP_PAGE_BECAUSE_NOT_PREVIOUS;
    private List<String> CHAT_SUCCESS_SHOW_SHOP_PAGE;
    private List<String> CHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_SHOP_PAGE;



    private List<String> CHAT_FAILURE_ADD_MAP_KIT_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_FAILURE_ADD_MAP_KIT_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_FAILURE_ADD_MAP_KIT_BECAUSE_MAP_ALREADY_ADD_KIT;

    private List<String> CHAT_SUCCESS_SHOW_ALL_MEMBER_PAGE;
    private List<String> CHAT_SUCCESS_REMOVE_MAP_KIT;


    private List<String> CHAT_SUCCESS_ENABLE_PLUGIN;
    private List<String> CHAT_SUCCESS_DISABLE_PLUGIN;
    
    private List<String> CHAT_FAILURE_REMOVE_MAP_KIT_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_FAILURE_REMOVE_MAP_KIT_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_FAILURE_REMOVE_MAP_KIT_BECAUSE_MAP_NOT_ADD_KIT;

    private List<String> CHAT_SUCCESS_ADD_KIT_DESCRIPTION;
    private List<String> CHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_MATCHING;

    public List<String> getCHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_MATCHING() {
        if (CHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_MATCHING==null){
            return null;
        }
        return new ArrayList<>(CHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_MATCHING);
    }

    private List<String> CHAT_FAILURE_ADD_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_FAILURE_REMOVE_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_FAILURE_REMOVE_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW;

    private List<String> CHAT_SUCCESS_KIT_DESCRIPTION_REMOVE;

    private List<String> CHAT_FAILURE_SET_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_FAILURE_SET_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW;

    private List<String> CHAT_SUCCESS_SET_KIT_DESCRIPTION;
    private List<String> CHAT_FAILURE_CREATE_PARTY_BECAUSE_ALREADY_JOIN_PARTY;

    private List<String> CHAT_FAILURE_CREATE_PARTY_BECAUSE_IN_WATCHING;
    private List<String> CHAT_SUCCESS_CREATE_PARTY;

    private List<String> CHAT_FAILURE_JOIN_PARTY_BECAUSE_ALREADY_JOIN_PARTY;

    private List<String> CHAT_FAILURE_KICK_MEMBER_BECAUSE_NOT_CAPTAIN;

    private List<String> CHAT_SUCCESS_JOIN_PARTY;
    private List<String> CHAT_SOMEONE_SUCCESS_JOIN_PARTY;
    private List<String> CHAT_SOMEONE_SUCCESS_LEAVE_PARTY;
    private List<String> CHAT_SOMEONE_SUCCESS_WAS_KICKED_PARTY;

    private List<String> CHAT_SUCCESS_SUBTRACT_CUMULATIVE_STAR;
    private List<String> CHAT_SUCCESS_SET_CUMULATIVE_STAR;
    private List<String> CHAT_SUCCESS_PLUS_CUMULATIVE_STAR;

    private List<String> CHAT_FAILURE_SUBTRACT_CUMULATIVE_STAR_BECAUSE_NOT_ENOUGH_STAR;
    private List<String> CHAT_SUCCESS_WAS_SUBTRACTED_CUMULATIVE_STAR;
    private List<String> CHAT_SUCCESS_WAS_SET_CUMULATIVE_STAR;
    private List<String> CHAT_SUCCESS_WAS_PLUS_CUMULATIVE_STAR;

    private List<String> CHAT_SUCCESS_SHOW_RANK_PAGE;

    private List<String> CHAT_SUCCESS_WAS_KICKED_PARTY;


    private String TITLE_CHOOSE_KIT_TIME_TITLE;
    private String TITLE_CHOOSE_KIT_TIME_SUBTITLE;

    private String TITLE_MATCH_TIME_TITLE;
    private String TITLE_MATCH_TIME_SUBTITLE;

    private List<String> CHAT_FAILURE_SHOW_ALL_MEMBER_PAGE_BECAUSE_NOT_JOIN_PARTY;
    private List<String> CHAT_SUCCESS_CANCEL_MATCH;
    private List<String> CHAT_SOMEONE_SUCCESS_CANCEL_MATCH;
    private List<String> CHAT_SUCCESS_START_SPECIFIC_MATCH;
    private List<String> CHAT_SOMEONE_SUCCESS_START_SPECIFIC_MATCH;


    private List<String> CHAT_SUCCESS_START_RANDOM_MATCH;
    private List<String> CHAT_SOMEONE_SUCCESS_START_RANDOM_MATCH;


    private List<String> CHAT_FAILURE_CANCEL_MATCH_BECAUSE_PARTY_IS_NOT_MATCHING;
    private List<String> CHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_PARTY_IS_MATCHING;
    private List<String> CHAT_FAILURE_START_SPECIFIC_MATCH_BECAUSE_PARTY_IS_MATCHING;


    private List<String> CHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_NOT_AVAILABLE_MAP;
    private List<String> CHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_NOT_CAPTAIN;
    private List<String> CHAT_FAILURE_START_SPECIFIC_MATCH_BECAUSE_NOT_CAPTAIN;

    private List<String> CHAT_FAILURE_JOIN_PARTY_BECAUSE_PARTY_IS_MATCHING;
    private List<String> CHAT_FAILURE_LEAVE_PARTY_BECAUSE_PARTY_IS_MATCHING;
    private List<String> CHAT_FAILURE_KICK_MEMBER_BECAUSE_PARTY_IS_MATCHING;


    private List<String> CHAT_SOMEONE_SUCCESS_RACE_STOP_DRAW;

    private List<String> CHAT_SOMEONE_SUCCESS_RACE_STOP_NOT_DRAW;

    private List<String> CHAT_SUCCESS_START_RACE;
    private List<String> CHAT_SUCCESS_KICK_MEMBER;
    private List<String> CHAT_FAILURE_CREATE_PARTY_BECAUSE_DUPLICATE_PARTY_NAME;
    private List<String> CHAT_HOW_TO_CREATE_PARTY;

    private List<String> CHAT_SUCCESS_BACK_ALL_PARTY_PAGE;

    private List<String> CHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_RANK_PAGE;

    private List<String> CHAT_SUCCESS_CHOOSE_KIT;
    private List<String> CHAT_SUCCESS_STOP_CHOOSE_KIT;
    private List<String> CHAT_SUCCESS_BACK_ALL_MEMBER_PAGE;
    private List<String> CHAT_SUCCESS_SHOW_ALL_MAP_PAGE;

    private List<String> CHAT_SUCCESS_NEXT_ALL_MAP_PAGE;
    private List<String> CHAT_SUCCESS_NEXT_ALL_MEMBER_PAGE;
    private List<String> CHAT_SUCCESS_NEXT_ALL_PARTY_PAGE;
    private List<String> CHAT_SUCCESS_NEXT_ALL_KIT_PAGE;
    private List<String> CHAT_SUCCESS_PREVIOUS_ALL_MAP_PAGE;
    private List<String> CHAT_SUCCESS_PREVIOUS_ALL_MEMBER_PAGE;
    private List<String> CHAT_SUCCESS_PREVIOUS_ALL_PARTY_PAGE;
    private List<String> CHAT_SUCCESS_PREVIOUS_ALL_KIT_PAGE;

    private List<String> CHAT_SUCCESS_PREVIOUS_RANK_PAGE;
    private List<String> CHAT_SUCCESS_NEXT_RANK_PAGE;


    private List<String> CHAT_SUCCESS_PREVIOUS_ALL_RACE_PAGE;
    private List<String> CHAT_SUCCESS_NEXT_ALL_RACE_PAGE;

    private List<String> CHAT_FAILURE_PREVIOUS_ALL_RACE_PAGE_BECAUSE_NOT_NEXT;
    private List<String> CHAT_FAILURE_NEXT_ALL_RACE_PAGE_BECAUSE_NOT_NEXT;


    private List<String> CHAT_FAILURE_PREVIOUS_RANK_PAGE_BECAUSE_NOT_NEXT;
    private List<String> CHAT_FAILURE_NEXT_RANK_PAGE_BECAUSE_NOT_NEXT;

    private List<String> CHAT_FAILURE_NEXT_ALL_MAP_PAGE_BECAUSE_NOT_NEXT;
    private List<String> CHAT_FAILURE_NEXT_ALL_MEMBER_PAGE_BECAUSE_NOT_NEXT;
    private List<String> CHAT_FAILURE_NEXT_ALL_PARTY_PAGE_BECAUSE_NOT_NEXT;
    private List<String> CHAT_FAILURE_NEXT_ALL_KIT_PAGE_BECAUSE_NOT_NEXT;
    private List<String> CHAT_FAILURE_PREVIOUS_ALL_MAP_PAGE_BECAUSE_NOT_PREVIOUS;
    private List<String> CHAT_FAILURE_PREVIOUS_ALL_MEMBER_PAGE_BECAUSE_NOT_PREVIOUS;
    private List<String> CHAT_FAILURE_PREVIOUS_ALL_PARTY_PAGE_BECAUSE_NOT_PREVIOUS;
    private List<String> CHAT_FAILURE_PREVIOUS_ALL_KIT_PAGE_BECAUSE_NOT_PREVIOUS;



    private List<String> COMPLETER_EASY_PVP;
    private List<String> COMPLETER_EASY_PVP_CREATE_KIT;
    private List<String> COMPLETER_EASY_PVP_DELETE_KIT;
    private List<String> COMPLETER_EASY_PVP_ADD_KIT_DESCRIPTION;
    private List<String> COMPLETER_EASY_PVP_ADD_KIT_DESCRIPTION_$;
    private List<String> COMPLETER_EASY_PVP_REMOVE_KIT_DESCRIPTION_$;
    private List<String> COMPLETER_EASY_PVP_REMOVE_KIT_DESCRIPTION;


    private List<String> COMPLETER_EASY_PVP_SET_CUMULATIVE_STAR;
    private List<String> COMPLETER_EASY_PVP_SUBTRACT_CUMULATIVE_STAR;
    private List<String> COMPLETER_EASY_PVP_PLUS_CUMULATIVE_STAR;
    private List<String> COMPLETER_EASY_PVP_SET_CUMULATIVE_STAR_$;
    private List<String> COMPLETER_EASY_PVP_SUBTRACT_CUMULATIVE_STAR_$;
    private List<String> COMPLETER_EASY_PVP_PLUS_CUMULATIVE_STAR_$;





    private List<String> COMPLETER_EASY_PVP_KIT_SET_DESCRIPTION_$_$;
    private List<String> COMPLETER_EASY_PVP_SET_KIT_DESCRIPTION_$;
    private List<String> COMPLETER_EASY_PVP_KIT_SET_DESCRIPTION;
    private List<String> COMPLETER_EASY_PVP_SET_KIT;
    private List<String> COMPLETER_EASY_PVP_SET_MAP_BUILD;
    private List<String> COMPLETER_EASY_PVP_SET_MAP_BUILD_$;
    private List<String> COMPLETER_EASY_PVP_SET_MAP_CHOOSE_TIME;
    private List<String> COMPLETER_EASY_PVP_SET_MAP_CHOOSE_TIME_$;
    private List<String> COMPLETER_EASY_PVP_CREATE_MAP;
    private List<String> COMPLETER_EASY_PVP_DELETE_MAP;
    private List<String> COMPLETER_EASY_PVP_ADD_MAP_DESCRIPTION;
    private List<String> COMPLETER_EASY_PVP_ADD_MAP_DESCRIPTION_$;

    private List<String> COMPLETER_EASY_PVP_REMOVE_MAP_DESCRIPTION;
    private List<String> COMPLETER_EASY_PVP_REMOVE_MAP_DESCRIPTION_$;

    private List<String> COMPLETER_EASY_PVP_SET_MAP_DESCRIPTION;
    private List<String> COMPLETER_EASY_PVP_SET_MAP_DESCRIPTION_$;

    private List<String> COMPLETER_EASY_PVP_SET_MAP_DESCRIPTION_$_$;
    private List<String> COMPLETER_EASY_PVP_SET_MAP_KEEP_INVENTORY;
    private List<String> COMPLETER_EASY_PVP_SET_MAP_KEEP_INVENTORY_$;

    private List<String> COMPLETER_EASY_PVP_SET_MAP_KEEP_LEVEL;
    private List<String> COMPLETER_EASY_PVP_SET_MAP_KEEP_LEVEL_$;
    private List<String> COMPLETER_EASY_PVP_SET_MAP_FAIR;
    private List<String> COMPLETER_EASY_PVP_SET_MAP_FAIR_$;


    private List<String> COMPLETER_EASY_PVP_SET_MAP_SCALE;
    private List<String> COMPLETER_EASY_PVP_SET_MAP_SCALE_$;


    private List<String> COMPLETER_EASY_PVP_ADD_MAP_KIT;
    private List<String> COMPLETER_EASY_PVP_ADD_MAP_KIT_$;

    private List<String> COMPLETER_EASY_PVP_REMOVE_MAP_KIT;
    private List<String> COMPLETER_EASY_PVP_REMOVE_MAP_KIT_$;

    private List<String> COMPLETER_EASY_PVP_SET_SECTION;


    public List<String> getCOMPLETER_EASY_PVP() {
        if (COMPLETER_EASY_PVP==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP);
    }

    public List<String> getCOMPLETER_EASY_PVP_CREATE_KIT() {
        if (COMPLETER_EASY_PVP_CREATE_KIT ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_CREATE_KIT);
    }

    public List<String> getCOMPLETER_EASY_PVP_DELETE_KIT() {
        if (COMPLETER_EASY_PVP_DELETE_KIT ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_DELETE_KIT);
    }

    public List<String> getCOMPLETER_EASY_PVP_ADD_KIT_DESCRIPTION() {
        if (COMPLETER_EASY_PVP_ADD_KIT_DESCRIPTION ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_ADD_KIT_DESCRIPTION);
    }

    public List<String> getCOMPLETER_EASY_PVP_ADD_KIT_DESCRIPTION_$() {
        if (COMPLETER_EASY_PVP_ADD_KIT_DESCRIPTION_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_ADD_KIT_DESCRIPTION_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_REMOVE_KIT_DESCRIPTION_$() {
        if (COMPLETER_EASY_PVP_REMOVE_KIT_DESCRIPTION_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_REMOVE_KIT_DESCRIPTION_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_REMOVE_KIT_DESCRIPTION() {
        if (COMPLETER_EASY_PVP_REMOVE_KIT_DESCRIPTION ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_REMOVE_KIT_DESCRIPTION);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_KIT_DESCRIPTION_$() {
        if (COMPLETER_EASY_PVP_SET_KIT_DESCRIPTION_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_KIT_DESCRIPTION_$);
    }
    public List<String> getCOMPLETER_EASY_PVP_KIT_SET_DESCRIPTION_$_$() {
        if (COMPLETER_EASY_PVP_KIT_SET_DESCRIPTION_$_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_KIT_SET_DESCRIPTION_$_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_KIT_SET_DESCRIPTION() {
        if (COMPLETER_EASY_PVP_KIT_SET_DESCRIPTION ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_KIT_SET_DESCRIPTION);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_KIT() {
        if (COMPLETER_EASY_PVP_SET_KIT ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_KIT);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_MAP_BUILD() {
        if (COMPLETER_EASY_PVP_SET_MAP_BUILD ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_MAP_BUILD);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_MAP_BUILD_$() {
        if (COMPLETER_EASY_PVP_SET_MAP_BUILD_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_MAP_BUILD_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_MAP_CHOOSE_TIME() {
        if (COMPLETER_EASY_PVP_SET_MAP_CHOOSE_TIME ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_MAP_CHOOSE_TIME);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_MAP_CHOOSE_TIME_$() {
        if (COMPLETER_EASY_PVP_SET_MAP_CHOOSE_TIME_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_MAP_CHOOSE_TIME_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_CREATE_MAP() {
        if (COMPLETER_EASY_PVP_CREATE_MAP ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_CREATE_MAP);
    }

    public List<String> getCOMPLETER_EASY_PVP_DELETE_MAP() {
        if (COMPLETER_EASY_PVP_DELETE_MAP ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_DELETE_MAP);
    }

    public List<String> getCOMPLETER_EASY_PVP_ADD_MAP_DESCRIPTION() {
        if (COMPLETER_EASY_PVP_ADD_MAP_DESCRIPTION ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_ADD_MAP_DESCRIPTION);
    }

    public List<String> getCOMPLETER_EASY_PVP_ADD_MAP_DESCRIPTION_$() {
        if (COMPLETER_EASY_PVP_ADD_MAP_DESCRIPTION_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_ADD_MAP_DESCRIPTION_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_REMOVE_MAP_DESCRIPTION() {
        if (COMPLETER_EASY_PVP_REMOVE_MAP_DESCRIPTION ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_REMOVE_MAP_DESCRIPTION);
    }

    public List<String> getCOMPLETER_EASY_PVP_REMOVE_MAP_DESCRIPTION_$() {
        if (COMPLETER_EASY_PVP_REMOVE_MAP_DESCRIPTION_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_REMOVE_MAP_DESCRIPTION_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_MAP_DESCRIPTION() {
        if (COMPLETER_EASY_PVP_SET_MAP_DESCRIPTION ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_MAP_DESCRIPTION);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_MAP_DESCRIPTION_$() {
        if (COMPLETER_EASY_PVP_SET_MAP_DESCRIPTION_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_MAP_DESCRIPTION_$);
    }
    public List<String> getCOMPLETER_EASY_PVP_SET_MAP_DESCRIPTION_$_$() {
        if (COMPLETER_EASY_PVP_SET_MAP_DESCRIPTION_$_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_MAP_DESCRIPTION_$_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_MAP_KEEP_INVENTORY() {
        if (COMPLETER_EASY_PVP_SET_MAP_KEEP_INVENTORY ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_MAP_KEEP_INVENTORY);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_MAP_KEEP_INVENTORY_$() {
        if (COMPLETER_EASY_PVP_SET_MAP_KEEP_INVENTORY_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_MAP_KEEP_INVENTORY_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_MAP_FAIR() {
        if (COMPLETER_EASY_PVP_SET_MAP_FAIR ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_MAP_FAIR);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_MAP_FAIR_$() {
        if (COMPLETER_EASY_PVP_SET_MAP_FAIR_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_MAP_FAIR_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_MAP_SCALE() {
        if (COMPLETER_EASY_PVP_SET_MAP_SCALE ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_MAP_SCALE);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_MAP_SCALE_$() {
        if (COMPLETER_EASY_PVP_SET_MAP_SCALE_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_MAP_SCALE_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_ADD_MAP_KIT() {
        if (COMPLETER_EASY_PVP_ADD_MAP_KIT ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_ADD_MAP_KIT);
    }

    public List<String> getCOMPLETER_EASY_PVP_ADD_MAP_KIT_$() {
        if (COMPLETER_EASY_PVP_ADD_MAP_KIT_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_ADD_MAP_KIT_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_REMOVE_MAP_KIT() {
        if (COMPLETER_EASY_PVP_REMOVE_MAP_KIT ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_REMOVE_MAP_KIT);
    }

    public List<String> getCOMPLETER_EASY_PVP_REMOVE_MAP_KIT_$() {
        if (COMPLETER_EASY_PVP_REMOVE_MAP_KIT_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_REMOVE_MAP_KIT_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_SECTION() {
        if (COMPLETER_EASY_PVP_SET_SECTION ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_SECTION);
    }

    public List<String> getCHAT_FAILURE_JOIN_PARTY_BECAUSE_PARTY_IS_RACING() {
        if (CHAT_FAILURE_JOIN_PARTY_BECAUSE_PARTY_IS_RACING==null){
            return null;
        } return new ArrayList<>(CHAT_FAILURE_JOIN_PARTY_BECAUSE_PARTY_IS_RACING);
    }

    public List<String> getCHAT_FAILURE_JOIN_PARTY_BECAUSE_IN_WATCHING() {
        if (CHAT_FAILURE_JOIN_PARTY_BECAUSE_IN_WATCHING==null){
            return null;
        } return new ArrayList<>(CHAT_FAILURE_JOIN_PARTY_BECAUSE_IN_WATCHING);
    }

    public String getTITLE_CHOOSE_KIT_TIME_TITLE() {
        return TITLE_CHOOSE_KIT_TIME_TITLE;
    }

    public String getTITLE_CHOOSE_KIT_TIME_SUBTITLE() {
        return TITLE_CHOOSE_KIT_TIME_SUBTITLE;
    }


    public String getTITLE_MATCH_TIME_SUBTITLE() {
        return TITLE_MATCH_TIME_SUBTITLE;
    }

    public String getTITLE_MATCH_TIME_TITLE() {
        return TITLE_MATCH_TIME_TITLE;
    }

    public List<String> getCHAT_SUCCESS_SET_MAP_KEEP_LEVEL() {
        if (CHAT_SUCCESS_SET_MAP_KEEP_LEVEL==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_SET_MAP_KEEP_LEVEL);
    }

    public List<String> getCHAT_FAILURE_SET_MAP_KEEP_LEVEL_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_SET_MAP_KEEP_LEVEL_BECAUSE_NOT_EXIST_MAP_NAME==null){
            return null;
        } return new ArrayList<>(CHAT_FAILURE_SET_MAP_KEEP_LEVEL_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_MAP_KEEP_LEVEL() {
        if (COMPLETER_EASY_PVP_SET_MAP_KEEP_LEVEL ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_MAP_KEEP_LEVEL);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_MAP_KEEP_LEVEL_$() {
        if (COMPLETER_EASY_PVP_SET_MAP_KEEP_LEVEL_$ ==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SET_MAP_KEEP_LEVEL_$);
    }

    public HashMap<Integer, List<String>> getCHAT_STREAK() {
        HashMap<Integer,List<String>> hashMap=new HashMap<>(CHAT_STREAK);

        for (int k:CHAT_STREAK.keySet()){
            hashMap.put(k,new ArrayList<>(CHAT_STREAK.get(k)));
        }
        return hashMap;
    }

    public List<String> getCHAT_SUCCESS_SUBTRACT_CUMULATIVE_STAR() {
        if (CHAT_SUCCESS_SUBTRACT_CUMULATIVE_STAR ==null){
            return null;
        } return new ArrayList<>(CHAT_SUCCESS_SUBTRACT_CUMULATIVE_STAR);
    }

    public List<String> getCHAT_SUCCESS_SET_CUMULATIVE_STAR() {
        if (CHAT_SUCCESS_SET_CUMULATIVE_STAR ==null){
            return null;
        } return new ArrayList<>(CHAT_SUCCESS_SET_CUMULATIVE_STAR);
    }

    public List<String> getCHAT_SUCCESS_PLUS_CUMULATIVE_STAR() {
        if (CHAT_SUCCESS_PLUS_CUMULATIVE_STAR ==null){
            return null;
        } return new ArrayList<>(CHAT_SUCCESS_PLUS_CUMULATIVE_STAR);
    }

    public List<String> getCHAT_FAILURE_SUBTRACT_CUMULATIVE_STAR_BECAUSE_NOT_ENOUGH_STAR() {
        if (CHAT_FAILURE_SUBTRACT_CUMULATIVE_STAR_BECAUSE_NOT_ENOUGH_STAR ==null){
            return null;
        } return new ArrayList<>(CHAT_FAILURE_SUBTRACT_CUMULATIVE_STAR_BECAUSE_NOT_ENOUGH_STAR);
    }

    public List<String> getCHAT_SUCCESS_WAS_SUBTRACTED_CUMULATIVE_STAR() {
        if (CHAT_SUCCESS_WAS_SUBTRACTED_CUMULATIVE_STAR ==null){
            return null;
        } return new ArrayList<>(CHAT_SUCCESS_WAS_SUBTRACTED_CUMULATIVE_STAR);
    }

    public List<String> getCHAT_SUCCESS_WAS_SET_CUMULATIVE_STAR() {
        if (CHAT_SUCCESS_WAS_SET_CUMULATIVE_STAR ==null){
            return null;
        } return new ArrayList<>(CHAT_SUCCESS_WAS_SET_CUMULATIVE_STAR);
    }

    public List<String> getCHAT_SUCCESS_WAS_PLUS_CUMULATIVE_STAR() {
        if (CHAT_SUCCESS_WAS_PLUS_CUMULATIVE_STAR ==null){
            return null;
        } return new ArrayList<>(CHAT_SUCCESS_WAS_PLUS_CUMULATIVE_STAR);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_CUMULATIVE_STAR() {
        if (COMPLETER_EASY_PVP_SET_CUMULATIVE_STAR ==null){
            return null;
        }  return new ArrayList<>(COMPLETER_EASY_PVP_SET_CUMULATIVE_STAR);
    }

    public List<String> getCOMPLETER_EASY_PVP_SUBTRACT_CUMULATIVE_STAR() {
        if (COMPLETER_EASY_PVP_SUBTRACT_CUMULATIVE_STAR ==null){
            return null;
        }  return new ArrayList<>(COMPLETER_EASY_PVP_SUBTRACT_CUMULATIVE_STAR);
    }

    public List<String> getCOMPLETER_EASY_PVP_PLUS_CUMULATIVE_STAR() {
        if (COMPLETER_EASY_PVP_PLUS_CUMULATIVE_STAR ==null){
            return null;
        }  return new ArrayList<>(COMPLETER_EASY_PVP_PLUS_CUMULATIVE_STAR);
    }

    public List<String> getCOMPLETER_EASY_PVP_SET_CUMULATIVE_STAR_$() {

        if (COMPLETER_EASY_PVP_SET_CUMULATIVE_STAR_$ ==null){
            return null;
        }  return new ArrayList<>(COMPLETER_EASY_PVP_SET_CUMULATIVE_STAR_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_SUBTRACT_CUMULATIVE_STAR_$() {

        if (COMPLETER_EASY_PVP_SUBTRACT_CUMULATIVE_STAR_$ ==null){
            return null;
        }  return new ArrayList<>(COMPLETER_EASY_PVP_SUBTRACT_CUMULATIVE_STAR_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_PLUS_CUMULATIVE_STAR_$() {

        if (COMPLETER_EASY_PVP_PLUS_CUMULATIVE_STAR_$ ==null){
            return null;
        }  return new ArrayList<>(COMPLETER_EASY_PVP_PLUS_CUMULATIVE_STAR_$);
    }

    public List<String> getCHAT_SUCCESS_NEXT_SHOP_PAGE() {
        if (CHAT_SUCCESS_NEXT_SHOP_PAGE ==null){
            return null;
        }  return new ArrayList<>(CHAT_SUCCESS_NEXT_SHOP_PAGE);
    }

    public List<String> getCHAT_SUCCESS_PREVIOUS_SHOP_PAGE() {
        if (CHAT_SUCCESS_PREVIOUS_SHOP_PAGE ==null){
            return null;
        }  return new ArrayList<>(CHAT_SUCCESS_PREVIOUS_SHOP_PAGE);
    }

    public List<String> getCHAT_FAILURE_NEXT_SHOP_PAGE_BECAUSE_NOT_NEXT() {
        if (CHAT_FAILURE_NEXT_SHOP_PAGE_BECAUSE_NOT_NEXT ==null){
            return null;
        }  return new ArrayList<>(CHAT_FAILURE_NEXT_SHOP_PAGE_BECAUSE_NOT_NEXT);
    }

    public List<String> getCHAT_FAILURE_PREVIOUS_SHOP_PAGE_BECAUSE_NOT_PREVIOUS() {
        if (CHAT_FAILURE_PREVIOUS_SHOP_PAGE_BECAUSE_NOT_PREVIOUS ==null){
            return null;
        }  return new ArrayList<>(CHAT_FAILURE_PREVIOUS_SHOP_PAGE_BECAUSE_NOT_PREVIOUS);
    }

    public List<String> getCHAT_SUCCESS_SHOW_SHOP_PAGE() {
        if (CHAT_SUCCESS_SHOW_SHOP_PAGE ==null){
            return null;
        }  return new ArrayList<>(CHAT_SUCCESS_SHOW_SHOP_PAGE);
    }

    public List<String> getCHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_SHOP_PAGE() {
        if (CHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_SHOP_PAGE ==null){
            return null;
        }  return new ArrayList<>(CHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_SHOP_PAGE);
    }

    @Override
    protected void check()  {

        CHAT_STREAK=new HashMap<>();
        for (String key:yamlConfiguration.getConfigurationSection("message.chat.streak").getKeys(false)){
            String last=key.split("\\.")[key.split("\\.").length-1];
            int q;
            try {q=Integer.valueOf(last);}catch (NumberFormatException e){continue;}
            if (q<0){continue;}
            if (getStringList("message.chat.streak."+key,false)==null){continue;}
            CHAT_STREAK.put(q,getStringList("message.chat.streak."+key,false));
        }


        COMPLETER_EASY_PVP=getStringList("message.completer.easyPvp",false);

        COMPLETER_EASY_PVP_CREATE_KIT =getStringList("message.completer.easyPvpCreateKit",false);
        COMPLETER_EASY_PVP_DELETE_KIT =getStringList("message.completer.easyPvpDeleteKit",false);
        COMPLETER_EASY_PVP_ADD_KIT_DESCRIPTION =getStringList("message.completer.easyPvpAddKitDescription",false);
        COMPLETER_EASY_PVP_ADD_KIT_DESCRIPTION_$ =getStringList("message.completer.easyPvpAddKitDescription$",false);
        COMPLETER_EASY_PVP_REMOVE_KIT_DESCRIPTION_$ =getStringList("message.completer.easyPvpRemoveKitDescription$",false);
        COMPLETER_EASY_PVP_REMOVE_KIT_DESCRIPTION =getStringList("message.completer.easyPvpRemoveKitDescription",false);
        COMPLETER_EASY_PVP_SET_KIT_DESCRIPTION_$ =getStringList("message.completer.easyPvpSetKitDescription$",false);

        COMPLETER_EASY_PVP_KIT_SET_DESCRIPTION_$_$ =getStringList("message.completer.easyPvpSetKitDescription$$",false);
        COMPLETER_EASY_PVP_KIT_SET_DESCRIPTION =getStringList("message.completer.easyPvpSetKitDescription",false);
        COMPLETER_EASY_PVP_SET_KIT =getStringList("message.completer.easyPvpSetKit",false);
        COMPLETER_EASY_PVP_SET_MAP_BUILD =getStringList("message.completer.easyPvpSetMapBuild",false);
        COMPLETER_EASY_PVP_SET_MAP_BUILD_$ =getStringList("message.completer.easyPvpSetMapBuild$",false);
        COMPLETER_EASY_PVP_SET_MAP_CHOOSE_TIME =getStringList("message.completer.easyPvpSetMapChooseTime",false);
        COMPLETER_EASY_PVP_SET_MAP_CHOOSE_TIME_$ =getStringList("message.completer.easyPvpSetMapChooseTime$",false);
        COMPLETER_EASY_PVP_CREATE_MAP =getStringList("message.completer.easyPvpCreateMap",false);
        COMPLETER_EASY_PVP_DELETE_MAP =getStringList("message.completer.easyPvpDeleteMap",false);
        COMPLETER_EASY_PVP_ADD_MAP_DESCRIPTION =getStringList("message.completer.easyPvpAddMapDescription",false);
        COMPLETER_EASY_PVP_ADD_MAP_DESCRIPTION_$ =getStringList("message.completer.easyPvpAddMapDescription$",false);
        COMPLETER_EASY_PVP_REMOVE_MAP_DESCRIPTION =getStringList("message.completer.easyPvpMapRemoveDescription",false);
        COMPLETER_EASY_PVP_REMOVE_MAP_DESCRIPTION_$ =getStringList("message.completer.easyPvpRemoveMapDescription$",false);
        COMPLETER_EASY_PVP_SET_MAP_DESCRIPTION =getStringList("message.completer.easyPvpSetMapDescription",false);
        COMPLETER_EASY_PVP_SET_MAP_DESCRIPTION_$ =getStringList("message.completer.easyPvpSetMapDescription$",false);
        COMPLETER_EASY_PVP_SET_MAP_DESCRIPTION_$_$ =getStringList("message.completer.easyPvpSetMapDescription$$",false);
        COMPLETER_EASY_PVP_SET_MAP_KEEP_INVENTORY =getStringList("message.completer.easyPvpSetMapKeepInventory",false);
        COMPLETER_EASY_PVP_SET_MAP_KEEP_INVENTORY_$ =getStringList("message.completer.easyPvpSetMapKeepInventory$",false);
        COMPLETER_EASY_PVP_SET_MAP_FAIR =getStringList("message.completer.easyPvpSetMapFair",false);
        COMPLETER_EASY_PVP_SET_MAP_FAIR_$ =getStringList("message.completer.easyPvpSetMapFair$",false);
        COMPLETER_EASY_PVP_SET_MAP_SCALE =getStringList("message.completer.easyPvpSetMapScale",false);
        COMPLETER_EASY_PVP_SET_MAP_SCALE_$ =getStringList("message.completer.easyPvpSetMapScale$",false);
        COMPLETER_EASY_PVP_ADD_MAP_KIT =getStringList("message.completer.easyPvpAddMapKit",false);
        COMPLETER_EASY_PVP_ADD_MAP_KIT_$ =getStringList("message.completer.easyPvpAddMapKit$",false);
        COMPLETER_EASY_PVP_REMOVE_MAP_KIT =getStringList("message.completer.easyPvpRemoveMapKit",false);
        COMPLETER_EASY_PVP_REMOVE_MAP_KIT_$ =getStringList("message.completer.easyPvpRemoveMapKit$",false);
        COMPLETER_EASY_PVP_SET_SECTION =getStringList("message.completer.easyPvpSetSection",false);
        COMPLETER_EASY_PVP_SET_MAP_KEEP_LEVEL =getStringList("message.completer.easyPvpSetMapKeepLevel",false);
        COMPLETER_EASY_PVP_SET_MAP_KEEP_LEVEL_$ =getStringList("message.completer.easyPvpSetMapKeepLevel$",false);



        CHAT_SUCCESS_NEXT_ALL_MAP_PAGE=getStringList("message.chat.successNextAllMapPage",false);
        CHAT_SUCCESS_NEXT_ALL_MEMBER_PAGE=getStringList("message.chat.successNextAllMemberPage",false);
        CHAT_SUCCESS_NEXT_ALL_PARTY_PAGE=getStringList("message.chat.successNextAllPartyPage",false);
        CHAT_SUCCESS_NEXT_ALL_KIT_PAGE=getStringList("message.chat.successNextAllKitPage",false);

        CHAT_SUCCESS_PREVIOUS_ALL_MAP_PAGE=getStringList("message.chat.successPreviousAllMapPage",false);
        CHAT_SUCCESS_PREVIOUS_ALL_MEMBER_PAGE=getStringList("message.chat.successPreviousAllMemberPage",false);
        CHAT_SUCCESS_PREVIOUS_ALL_PARTY_PAGE=getStringList("message.chat.successPreviousAllPartyPage",false);
        CHAT_SUCCESS_PREVIOUS_ALL_KIT_PAGE=getStringList("message.chat.successPreviousAllKitPage",false);

        CHAT_FAILURE_NEXT_ALL_MAP_PAGE_BECAUSE_NOT_NEXT=getStringList("message.chat.failureNextAllMapPageBecauseNotNext",false);
        CHAT_FAILURE_NEXT_ALL_MEMBER_PAGE_BECAUSE_NOT_NEXT=getStringList("message.chat.failureNextAllMemberPageBecauseNotNext",false);
        CHAT_FAILURE_NEXT_ALL_PARTY_PAGE_BECAUSE_NOT_NEXT=getStringList("message.chat.failureNextAllPartyPageBecauseNotNext",false);
        CHAT_FAILURE_NEXT_ALL_KIT_PAGE_BECAUSE_NOT_NEXT=getStringList("message.chat.failureNextAllKitPageBecauseNotNext",false);
        CHAT_FAILURE_PREVIOUS_ALL_MAP_PAGE_BECAUSE_NOT_PREVIOUS=getStringList("message.chat.failurePreviousAllMapPageBecauseNotPrevious",false);
        CHAT_FAILURE_PREVIOUS_ALL_MEMBER_PAGE_BECAUSE_NOT_PREVIOUS=getStringList("message.chat.failurePreviousAllMemberPageBecauseNotPrevious",false);
        CHAT_FAILURE_PREVIOUS_ALL_PARTY_PAGE_BECAUSE_NOT_PREVIOUS=getStringList("message.chat.failurePreviousAllPartyPageBecauseNotPrevious",false);
        CHAT_FAILURE_PREVIOUS_ALL_KIT_PAGE_BECAUSE_NOT_PREVIOUS=getStringList("message.chat.failurePreviousAllKitPageBecauseNotPrevious",false);


        CHAT_SUCCESS_SUBTRACT_CUMULATIVE_STAR=getStringList("message.chat.successSubtractCumulativeStar",false);
        CHAT_SUCCESS_SET_CUMULATIVE_STAR=getStringList("message.chat.successSetCumulativeStar",false);
        CHAT_SUCCESS_PLUS_CUMULATIVE_STAR=getStringList("message.chat.successPlusCumulativeStar",false);
        CHAT_FAILURE_SUBTRACT_CUMULATIVE_STAR_BECAUSE_NOT_ENOUGH_STAR=getStringList("message.chat.failureSubtractCumulativeStarBecauseNotEnoughStar",false);
        CHAT_SUCCESS_WAS_SUBTRACTED_CUMULATIVE_STAR=getStringList("message.chat.successWasSubtractCumulativeStar",false);
        CHAT_SUCCESS_WAS_SET_CUMULATIVE_STAR=getStringList("message.chat.successWasSetCumulativeStar",false);
        CHAT_SUCCESS_WAS_PLUS_CUMULATIVE_STAR=getStringList("message.chat.successWasPlusCumulativeStar",false);
        


        CHAT_SUCCESS_NOTIFY_VERSION =getStringList("message.chat.successNotifyVersion",false);
        CHAT_NOT_PLAYER=getStringList("message.chat.notPlayer",false);

        CHAT_NO_PERMISSION=getStringList("message.chat.noPermission",false);
        CHAT_SUCCESS_KICK_MEMBER =getStringList("message.chat.successKickMember",false);


        CHAT_SUCCESS_OPEN_GUI =getStringList("message.chat.successOpenGui",false);
        CHAT_SUCCESS_HELP =getStringList("message.chat.successHelp",false);

        CHAT_SUCCESS_CORRECT_YAML=getStringList("message.chat.successCorrectYaml",false);
        CHAT_SUCCESS_RESET_SEASON =getStringList("message.chat.successResetSeason",false);

        CHAT_SUCCESS_RELOAD_YAML =getStringList("message.chat.successReloadYaml",false);


        CHAT_SUCCESS_SHOW_RANK_PAGE =getStringList("message.chat.successShowRankPage",false);

        CHAT_SUCCESS_SET_SECTION =getStringList("message.chat.successSetSection",false);

        CHAT_INVALID_ARGUMENT=getStringList("message.chat.invalidArgument",false);

        CHAT_FAILURE_MAP_CREATE_BECAUSE_INVALID_FOUR_POINT =getStringList
                ("message.chat.failureMapCreateBecauseInvalidFourPoint",false);

        CHAT_FAILURE_MAP_CREATE_BECAUSE_NOT_FOUR_POINT =getStringList
                ("message.chat.failureMapCreateBecauseNotFourPoint",false);

        CHAT_SUCCESS_CREATE_MAP =getStringList("message.chat.successCreateMap",false);
        CHAT_FAILURE_CREATE_MAP_BECAUSE_DUPLICATE_MAP_NAME =getStringList
                ("message.chat.failureCreateMapBecauseDuplicateMapName",false);

        CHAT_SUCCESS_DELETE_MAP =getStringList("message.chat.successDeleteMap",false);
        CHAT_FAILURE_DELETE_MAP_BECAUSE_NOT_EXIST_MAP_NAME =getStringList
                ("message.chat.failureDeleteMapBecauseNotExistMapName",false);

        CHAT_SUCCESS_ADD_MAP_DESCRIPTION =getStringList("message.chat.successAddMapDescription",false);
        CHAT_FAILURE_ADD_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME =getStringList
                ("message.chat.failureAddMapDescriptionBecauseNotExistMapName",false);

        CHAT_FAILURE_MAP_REMOVE_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME =getStringList
                ("message.chat.failureRemoveMapDescriptionBecauseNotExistMapName",false);
        CHAT_FAILURE_REMOVE_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW =getStringList
                ("message.chat.failureRemoveMapDescriptionBecauseNotExistDescriptionRow",false);
        CHAT_SUCCESS_REMOVE_MAP_DESCRIPTION =getStringList("message.chat.successRemoveMapDescription",false);

        CHAT_FAILURE_SET_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME =getStringList
                ("message.chat.failureSetMapDescriptionBecauseNotExistMapName",false);
        CHAT_FAILURE_SET_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW =getStringList
                ("message.chat.failureSetMapDescriptionBecauseNotExistDescriptionRow",false);
        CHAT_SUCCESS_SET_MAP_DESCRIPTION =getStringList("message.chat.successSetMapDescription",false);

        CHAT_FAILURE_SET_MAP_BUILD_BECAUSE_NOT_EXIST_MAP_NAME =getStringList("message.chat.failureSetMapBuildBecauseNotExistMapName",false);
        CHAT_SUCCESS_SET_MAP_BUILD =getStringList("message.chat.successSetMapBuild",false);


        CHAT_FAILURE_SET_MAP_CHOOSE_TIME_BECAUSE_NOT_EXIST_MAP_NAME =getStringList("message.chat.failureSetMapChooseTimeBecauseNotExistMapName",false);
        CHAT_SUCCESS_SET_MAP_CHOOSE_TIME =getStringList("message.chat.successSetMapChooseTime",false);


        CHAT_FAILURE_SET_MAP_FAIR_BECAUSE_NOT_EXIST_MAP_NAME =getStringList("message.chat.failureSetMapFairBecauseNotExistMapName",false);
        CHAT_SUCCESS_SET_MAP_FAIR =getStringList("message.chat.successSetMapFair",false);

        CHAT_FAILURE_SET_MAP_SCALE_BECAUSE_NOT_EXIST_MAP_NAME =getStringList("message.chat.failureSetMapScaleBecauseNotExistMapName",false);
        CHAT_SUCCESS_SET_MAP_SCALE =getStringList("message.chat.successSetMapScale",false);

        CHAT_FAILURE_SET_MAP_KEEP_INVENTORY_BECAUSE_NOT_EXIST_MAP_NAME =getStringList("message.chat.failureSetMapKeepInventoryBecauseNotExistMapName",false);
        CHAT_SUCCESS_SET_MAP_KEEP_INVENTORY =getStringList("message.chat.successSetMapKeepInventory",false);
        CHAT_FAILURE_SET_MAP_KEEP_LEVEL_BECAUSE_NOT_EXIST_MAP_NAME =getStringList("message.chat.failureSetMapKeepLevelBecauseNotExistMapName",false);
        CHAT_SUCCESS_SET_MAP_KEEP_LEVEL =getStringList("message.chat.successSetMapKeepLevel",false);


        CHAT_SUCCESS_CREATE_KIT =getStringList("message.chat.successCreateKit",false);
        CHAT_FAILURE_CREATE_KIT_BECAUSE_DUPLICATE_KIT_NAME =getStringList
                ("message.chat.failureCreateKitBecauseDuplicateKitName",false);

        CHAT_SUCCESS_DELETE_KIT =getStringList("message.chat.successDeleteKit",false);
        CHAT_FAILURE_DELETE_KIT_BECAUSE_NOT_EXIST_KIT_NAME =getStringList
                ("message.chat.failureDeleteKitBecauseNotExistKitName",false);

        CHAT_SUCCESS_SET_KIT =getStringList("message.chat.successSetKit",false);
        CHAT_FAILURE_SET_KIT_BECAUSE_NOT_EXIST_KIT_NAME =getStringList
                ("message.chat.failureSetKitBecauseNotExistKitName",false);

        CHAT_SUCCESS_ADD_MAP_KIT =getStringList("message.chat.successAddMapKit",false);
        CHAT_FAILURE_ADD_MAP_KIT_BECAUSE_NOT_EXIST_KIT_NAME =getStringList
                ("message.chat.failureAddMapKitBecauseNotExistKitName",false);
        CHAT_FAILURE_ADD_MAP_KIT_BECAUSE_NOT_EXIST_MAP_NAME =getStringList
                ("message.chat.failureAddMapKitBecauseNotExistMapName",false);
        CHAT_FAILURE_ADD_MAP_KIT_BECAUSE_MAP_ALREADY_ADD_KIT =getStringList
                ("message.chat.failureAddMapKitBecauseMapAlreadyAddKit",false);

        CHAT_SUCCESS_NEXT_SHOP_PAGE=getStringList("message.chat.successNextShopPage",false);
        CHAT_SUCCESS_PREVIOUS_SHOP_PAGE=getStringList("message.chat.successPreviousShopPage",false);
        CHAT_FAILURE_NEXT_SHOP_PAGE_BECAUSE_NOT_NEXT=getStringList("message.chat.failureNextShopPageBecauseNotNext",false);
        CHAT_FAILURE_PREVIOUS_SHOP_PAGE_BECAUSE_NOT_PREVIOUS =getStringList("message.chat.failurePreviousShopPageBecauseNotPrevious",false);
        CHAT_SUCCESS_SHOW_SHOP_PAGE=getStringList("message.chat.successShowShopPage",false);
        CHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_SHOP_PAGE=getStringList("message.chat.successBackAllPartyPageInShopPage",false);



        CHAT_SUCCESS_REMOVE_MAP_KIT =getStringList("message.chat.successRemoveMapKit",false);
        CHAT_FAILURE_REMOVE_MAP_KIT_BECAUSE_NOT_EXIST_KIT_NAME =getStringList
                ("message.chat.failureRemoveMapKitBecauseNotExistKitName",false);
        CHAT_FAILURE_REMOVE_MAP_KIT_BECAUSE_NOT_EXIST_MAP_NAME =getStringList
                ("message.chat.failureRemoveMapKitBecauseNotExistMapName",false);
        CHAT_FAILURE_REMOVE_MAP_KIT_BECAUSE_MAP_NOT_ADD_KIT =getStringList
                ("message.chat.failureRemoveMapKitBecauseMapNotAddKit",false);

        CHAT_SUCCESS_ADD_KIT_DESCRIPTION =getStringList("message.chat.successAddKitDescription",false);
        CHAT_FAILURE_ADD_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME =getStringList
                ("message.chat.failureAddKitDescriptionBecauseNotExistKitName",false);

        CHAT_FAILURE_REMOVE_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME =getStringList
                ("message.chat.failureRemoveKitDescriptionBecauseNotExistKitName",false);
        CHAT_FAILURE_REMOVE_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW =getStringList
                ("message.chat.failureRemoveKitDescriptionBecauseNotExistDescriptionRow",false);
        CHAT_SUCCESS_KIT_DESCRIPTION_REMOVE=getStringList("message.chat.successKitDescriptionRemove",false);

        CHAT_FAILURE_SET_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME =getStringList
                ("message.chat.failureSetKitDescriptionBecauseNotExistKitName",false);
        CHAT_FAILURE_SET_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW =getStringList
                ("message.chat.failureSetKitDescriptionBecauseNotExistDescriptionRow",false);
        CHAT_SUCCESS_SET_KIT_DESCRIPTION =getStringList("message.chat.successSetKitDescription",false);

        CHAT_FAILURE_CREATE_PARTY_BECAUSE_ALREADY_JOIN_PARTY =getStringList
                ("message.chat.failureCreatePartyBecauseAlreadyJoinParty",false);

        CHAT_FAILURE_CREATE_PARTY_BECAUSE_IN_WATCHING =getStringList
                ("message.chat.failureCreatePartyBecauseInWatching",false);
        CHAT_SUCCESS_CREATE_PARTY=getStringList("message.chat.successCreateParty",false);
        CHAT_FAILURE_CREATE_PARTY_BECAUSE_DUPLICATE_PARTY_NAME =getStringList
                ("message.chat.failureCreatePartyBecauseDuplicatePartyName",false);
        CHAT_HOW_TO_CREATE_PARTY =getStringList
                ("message.chat.howToCreateParty",false);
        CHAT_SUCCESS_CANCEL_CREATE_PARTY=getStringList("message.chat.successCancelCreateParty",false);

        CHAT_FAILURE_JOIN_PARTY_BECAUSE_ALREADY_JOIN_PARTY =getStringList
                ("message.chat.failureJoinPartyBecauseAlreadyJoinParty",false);
        CHAT_SUCCESS_JOIN_PARTY=getStringList("message.chat.successJoinParty",false);
        CHAT_SOMEONE_SUCCESS_JOIN_PARTY=getStringList("message.chat.someoneSuccessJoinParty",false);

        CHAT_SOMEONE_SUCCESS_LEAVE_PARTY=getStringList("message.chat.someoneSuccessLeaveParty",false);
        CHAT_SOMEONE_SUCCESS_WAS_KICKED_PARTY=getStringList("message.chat.someoneSuccessKickMember",false);
        CHAT_SUCCESS_WAS_KICKED_PARTY=getStringList("message.chat.successWasKickedParty",false);

        CHAT_FAILURE_SHOW_ALL_MEMBER_PAGE_BECAUSE_NOT_JOIN_PARTY =getStringList
                ("message.chat.failureShowAllMemberPageBecauseNotJoinParty",false);

        CHAT_FAILURE_KICK_MEMBER_BECAUSE_PARTY_IS_MATCHING =getStringList
                ("message.chat.failureKickMemberBecausePartyIsMatching",false);

        CHAT_FAILURE_LEAVE_PARTY_BECAUSE_PARTY_IS_MATCHING =getStringList
                ("message.chat.failureLeavePartyBecausePartyIsMatching",false);
        CHAT_FAILURE_KICK_MEMBER_BECAUSE_NOT_CAPTAIN =getStringList
                ("message.chat.failureKickMemberBecauseNotCaptain",false);

        CHAT_SUCCESS_START_SPECIFIC_MATCH =getStringList("message.chat.successStartSpecificMatch",false);
        CHAT_SOMEONE_SUCCESS_START_SPECIFIC_MATCH =getStringList("message.chat.someoneSuccessStartSpecificMatch",false);
        CHAT_SUCCESS_CANCEL_MATCH=getStringList("message.chat.successCancelMatch",false);
        CHAT_SOMEONE_SUCCESS_CANCEL_MATCH=getStringList("message.chat.someoneSuccessCancelMatch",false);
        CHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_MATCHING=getStringList("message.chat.someoneSuccessQuitGameInMatching",false);


        CHAT_SUCCESS_START_RANDOM_MATCH =getStringList("message.chat.successStartRandomMatch",false);
        CHAT_SOMEONE_SUCCESS_START_RANDOM_MATCH =getStringList("message.chat.someoneSuccessStartRandomMatch",false);
        CHAT_FAILURE_CANCEL_MATCH_BECAUSE_PARTY_IS_NOT_MATCHING =getStringList
                ("message.chat.failureCancelMatchBecausePartyIsNotMatching",false);
        CHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_PARTY_IS_MATCHING =getStringList
                ("message.chat.failureStartRandomMatchBecausePartyIsMatching",false);
        CHAT_FAILURE_START_SPECIFIC_MATCH_BECAUSE_PARTY_IS_MATCHING =getStringList
                ("message.chat.failureStartSpecificMatchBecausePartyIsMatching",false);
        CHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_NOT_CAPTAIN =getStringList
                ("message.chat.failureStartRandomMatchBecauseNotCaptain",false);
        CHAT_FAILURE_START_SPECIFIC_MATCH_BECAUSE_NOT_CAPTAIN =getStringList
                ("message.chat.failureStartSpecificMatchBecauseNotCaptain",false);
        CHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_NOT_AVAILABLE_MAP =getStringList
                ("message.chat.failureStartRandomMatchBecauseNotAvailableMap",false);
        CHAT_FAILURE_JOIN_PARTY_BECAUSE_PARTY_IS_MATCHING =getStringList
                ("message.chat.failureJoinPartyBecausePartyIsMatching",false);


        CHAT_FAILURE_JOIN_PARTY_BECAUSE_PARTY_IS_RACING =getStringList
                ("message.chat.failureJoinPartyBecausePartyIsRacing",false);
        CHAT_FAILURE_JOIN_PARTY_BECAUSE_IN_WATCHING =getStringList
                ("message.chat.failureJoinPartyBecauseInWatching",false);
        TITLE_MATCH_TIME_SUBTITLE =getString("message.title.matchTime.subtitle",false);
        TITLE_MATCH_TIME_TITLE =getString("message.title.matchTime.title",false);
        TITLE_CHOOSE_KIT_TIME_SUBTITLE =getString("message.title.chooseKitTime.subtitle",false);
        TITLE_CHOOSE_KIT_TIME_TITLE =getString("message.title.chooseKitTime.title",false);
        CHAT_SUCCESS_START_RACE =getStringList("message.chat.successStartRace",false);

        CHAT_SOMEONE_SUCCESS_RACE_STOP_DRAW =getStringList("message.chat.someoneSuccessRaceStopDraw",false);
        CHAT_SOMEONE_SUCCESS_RACE_STOP_NOT_DRAW =getStringList("message.chat.someoneSuccessRaceStopNotDraw",false);
        CHAT_SUCCESS_SHOW_ALL_MEMBER_PAGE =getStringList("message.chat.successShowAllMemberPage",false);
        CHAT_SUCCESS_BACK_ALL_PARTY_PAGE =getStringList("message.chat.successBackAllPartyPage",false);

        CHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_RANK_PAGE =getStringList("message.chat.successBackAllPartyPageInRankPage",false);
        CHAT_SUCCESS_LEAVE_PARTY =getStringList("message.chat.successLeaveParty",false);

        CHAT_SUCCESS_SHOW_ALL_MAP_PAGE =getStringList("message.chat.successShowAllMapPage",false);
        CHAT_SUCCESS_BACK_ALL_MEMBER_PAGE =getStringList("message.chat.successBackAllMemberPage",false);

        CHAT_SUCCESS_CHOOSE_KIT =getStringList("message.chat.successChooseKit",false);
        CHAT_SUCCESS_STOP_CHOOSE_KIT =getStringList("message.chat.successStopChooseKit",false);

        CHAT_SUCCESS_NEXT_RANK_PAGE=getStringList("message.chat.successNextRankPage",false);
        CHAT_SUCCESS_PREVIOUS_RANK_PAGE=getStringList("message.chat.successPreviousRankPage",false);
        CHAT_FAILURE_NEXT_RANK_PAGE_BECAUSE_NOT_NEXT=getStringList("message.chat.failureNextRankPageBecauseNotNext",false);
        CHAT_FAILURE_PREVIOUS_RANK_PAGE_BECAUSE_NOT_NEXT=getStringList("message.chat.failurePreviousRankPageBecauseNotPrevious",false);


        CHAT_SUCCESS_NEXT_ALL_RACE_PAGE=getStringList("message.chat.successNextAllRacePage",false);
        CHAT_SUCCESS_PREVIOUS_ALL_RACE_PAGE=getStringList("message.chat.successPreviousAllRacePage",false);
        CHAT_FAILURE_NEXT_ALL_RACE_PAGE_BECAUSE_NOT_NEXT=getStringList("message.chat.failureNextAllRacePageBecauseNotNext",false);
        CHAT_FAILURE_PREVIOUS_ALL_RACE_PAGE_BECAUSE_NOT_NEXT=getStringList("message.chat.failurePreviousAllRacePageBecauseNotPrevious",false);
        CHAT_SUCCESS_SHOW_ALL_RACE_PAGE=getStringList("message.chat.successShowAllRacePage",false);
        CHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_ALL_RACE_PAGE=getStringList("message.chat.successBackAllPartyPageInAllRacePage",false);
        CHAT_SUCCESS_WATCH_RACE=getStringList("message.chat.successWatchRace",false);
        CHAT_FAILURE_WATCH_RACE_BECAUSE_IN_READING =getStringList("message.chat.failureWatchRaceBecauseInReading",false);

        CHAT_FAILURE_WATCH_RACE_BECAUSE_ALREADY_IN_WATCHING=getStringList("message.chat.failureWatchRaceBecauseAlreadyInWatching",false);
        CHAT_FAILURE_UNWATCH_RACE_BECAUSE_NOT_IN_WATCHING=getStringList("message.chat.failureUnwatchRaceBecauseNotInWatching",false);
        CHAT_SUCCESS_UNWATCH_RACE=getStringList("message.chat.successUnwatchRace",false);

        CHAT_SUCCESS_ENABLE_PLUGIN=getStringList("message.chat.successEnablePlugin",false);
        CHAT_SUCCESS_DISABLE_PLUGIN=getStringList("message.chat.successDisablePlugin",false);

        COMPLETER_EASY_PVP_SET_CUMULATIVE_STAR=getStringList("message.completer.easyPvpSetCumulativeStar",false);
        COMPLETER_EASY_PVP_SUBTRACT_CUMULATIVE_STAR=getStringList("message.completer.easyPvpSubtractCumulativeStar",false);
        COMPLETER_EASY_PVP_PLUS_CUMULATIVE_STAR=getStringList("message.completer.easyPvpPlusCumulativeStar",false);
        COMPLETER_EASY_PVP_SET_CUMULATIVE_STAR_$=getStringList("message.completer.easyPvpSetCumulativeStar$",false);
        COMPLETER_EASY_PVP_SUBTRACT_CUMULATIVE_STAR_$=getStringList("message.completer.easyPvpSubtractCumulativeStar$",false);
        COMPLETER_EASY_PVP_PLUS_CUMULATIVE_STAR_$=getStringList("message.completer.easyPvpPlusCumulativeStar$",false);

        CHAT_SOMEONE_SUCCESS_DEAD_IN_RACING =getStringList("message.chat.someoneSuccessDeadInRacing",false);
        CHAT_SOMEONE_SUCCESS_MOVE_OUT_MAP =getStringList("message.chat.someoneSuccessMoveOutMap",false);
        CHAT_SUCCESS_DEAD_IN_RACING =getStringList("message.chat.successDeadInRacing",false);
        CHAT_SUCCESS_MOVE_OUT_MAP =getStringList("message.chat.successMoveOutMap",false);

        CHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_READING=getStringList("message.chat.someoneSuccessQuitGameInReading",false);
        CHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_RACING=getStringList("message.chat.someoneSuccessQuitGameInRacing",false);

        CHAT_FAILURE_NOTIFY_VERSION_BECAUSE_NOT_GET_LATEST_VERSION =getStringList("message.chat.failureNotifyVersionBecauseNotGetLatestVersion",false);
        INPUT_CANCEL =getString("message.input.cancel",true);
       if (INPUT_CANCEL.contains(" ")||INPUT_CANCEL.equalsIgnoreCase("")){
           INPUT_CANCEL="取消";
       }

    }

    public List<String> getCHAT_SUCCESS_MOVE_OUT_MAP() {
        if (CHAT_SUCCESS_MOVE_OUT_MAP ==null){
            return null; }
        return new ArrayList<>(CHAT_SUCCESS_MOVE_OUT_MAP);
    }

    private List<String> CHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_READING;
    private List<String> CHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_RACING;

    public List<String> getCHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_RACING() {
        if (CHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_RACING ==null){
            return null; }
        return new ArrayList<>(CHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_RACING);
    }

    public List<String> getCHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_READING() {
        if (CHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_READING ==null){
            return null; }
        return new ArrayList<>(CHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_READING);
    }

    private List<String> CHAT_SUCCESS_MOVE_OUT_MAP;




    public List<String> getCHAT_SOMEONE_SUCCESS_DEAD_IN_RACING() {
        if (CHAT_SOMEONE_SUCCESS_DEAD_IN_RACING ==null){
            return null; }return new ArrayList<>(CHAT_SOMEONE_SUCCESS_DEAD_IN_RACING);
    }

    public List<String> getCHAT_SOMEONE_SUCCESS_MOVE_OUT_MAP() {
        if (CHAT_SOMEONE_SUCCESS_MOVE_OUT_MAP ==null){
            return null; }return new ArrayList<>(CHAT_SOMEONE_SUCCESS_MOVE_OUT_MAP);
    }

    public List<String> getCHAT_SUCCESS_DEAD_IN_RACING() {
        if (CHAT_SUCCESS_DEAD_IN_RACING ==null){
            return null; }return new ArrayList<>(CHAT_SUCCESS_DEAD_IN_RACING);
    }

    public List<String> getCHAT_FAILURE_NOTIFY_VERSION_BECAUSE_NOT_GET_LATEST_VERSION() {
        if (CHAT_FAILURE_NOTIFY_VERSION_BECAUSE_NOT_GET_LATEST_VERSION==null){
            return null; }return new ArrayList<>(CHAT_FAILURE_NOTIFY_VERSION_BECAUSE_NOT_GET_LATEST_VERSION);
    }
    
    
    
    

    public List<String> getCHAT_SUCCESS_ENABLE_PLUGIN() {
        if (CHAT_SUCCESS_ENABLE_PLUGIN==null){
            return null; }return new ArrayList<>(CHAT_SUCCESS_ENABLE_PLUGIN);
    }

    public List<String> getCHAT_SUCCESS_DISABLE_PLUGIN() {
        if (CHAT_SUCCESS_DISABLE_PLUGIN==null){
            return null; }return new ArrayList<>(CHAT_SUCCESS_DISABLE_PLUGIN);
    }

    public List<String> getCHAT_FAILURE_WATCH_RACE_BECAUSE_ALREADY_IN_WATCHING() {
        if (CHAT_FAILURE_WATCH_RACE_BECAUSE_ALREADY_IN_WATCHING==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_WATCH_RACE_BECAUSE_ALREADY_IN_WATCHING);
    }

    public List<String> getCHAT_FAILURE_UNWATCH_RACE_BECAUSE_NOT_IN_WATCHING() {
        if (CHAT_FAILURE_UNWATCH_RACE_BECAUSE_NOT_IN_WATCHING==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_UNWATCH_RACE_BECAUSE_NOT_IN_WATCHING);
    }

    public List<String> getCHAT_SUCCESS_UNWATCH_RACE() {
        if (CHAT_SUCCESS_UNWATCH_RACE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_UNWATCH_RACE);
    }

    public List<String> getCHAT_SUCCESS_PREVIOUS_ALL_RACE_PAGE() {
        if (CHAT_SUCCESS_PREVIOUS_ALL_RACE_PAGE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_PREVIOUS_ALL_RACE_PAGE);
    }

    public List<String> getCHAT_SUCCESS_NEXT_ALL_RACE_PAGE() {
        if (CHAT_SUCCESS_NEXT_ALL_RACE_PAGE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_NEXT_ALL_RACE_PAGE);
    }

    public List<String> getCHAT_FAILURE_PREVIOUS_ALL_RACE_PAGE_BECAUSE_NOT_NEXT() {
        if (CHAT_FAILURE_PREVIOUS_ALL_RACE_PAGE_BECAUSE_NOT_NEXT==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_PREVIOUS_ALL_RACE_PAGE_BECAUSE_NOT_NEXT);
    }

    public List<String> getCHAT_FAILURE_NEXT_ALL_RACE_PAGE_BECAUSE_NOT_NEXT() {
        if (CHAT_FAILURE_NEXT_ALL_RACE_PAGE_BECAUSE_NOT_NEXT==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_NEXT_ALL_RACE_PAGE_BECAUSE_NOT_NEXT);
    }

    public List<String> getCHAT_SUCCESS_SHOW_ALL_RACE_PAGE() {
        if (CHAT_SUCCESS_SHOW_ALL_RACE_PAGE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_SHOW_ALL_RACE_PAGE);
    }

    public List<String> getCHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_ALL_RACE_PAGE() {
        if (CHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_ALL_RACE_PAGE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_ALL_RACE_PAGE);
    }

    public List<String> getCHAT_SUCCESS_WATCH_RACE() {
        if (CHAT_SUCCESS_WATCH_RACE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_WATCH_RACE);
    }

    public List<String> getCHAT_FAILURE_WATCH_RACE_BECAUSE_IN_READING() {
        if (CHAT_FAILURE_WATCH_RACE_BECAUSE_IN_READING ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_WATCH_RACE_BECAUSE_IN_READING);
    }

    private List<String> CHAT_SUCCESS_SHOW_ALL_RACE_PAGE;
    private List<String> CHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_ALL_RACE_PAGE;
    private List<String> CHAT_SUCCESS_WATCH_RACE;
    private List<String> CHAT_FAILURE_WATCH_RACE_BECAUSE_IN_READING;
    private List<String> CHAT_FAILURE_WATCH_RACE_BECAUSE_ALREADY_IN_WATCHING;
    private List<String> CHAT_FAILURE_UNWATCH_RACE_BECAUSE_NOT_IN_WATCHING;

    private List<String> CHAT_SUCCESS_UNWATCH_RACE;

    public List<String> getCHAT_SUCCESS_PREVIOUS_RANK_PAGE() {
        if (CHAT_SUCCESS_PREVIOUS_RANK_PAGE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_PREVIOUS_RANK_PAGE);
    }

    public List<String> getCHAT_SUCCESS_NEXT_RANK_PAGE() {
        if (CHAT_SUCCESS_NEXT_RANK_PAGE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_NEXT_RANK_PAGE);
    }

    public List<String> getCHAT_FAILURE_PREVIOUS_RANK_PAGE_BECAUSE_NOT_NEXT() {
        if (CHAT_FAILURE_PREVIOUS_RANK_PAGE_BECAUSE_NOT_NEXT==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_PREVIOUS_RANK_PAGE_BECAUSE_NOT_NEXT);
    }

    public List<String> getCHAT_FAILURE_NEXT_RANK_PAGE_BECAUSE_NOT_NEXT() {
        if (CHAT_FAILURE_NEXT_RANK_PAGE_BECAUSE_NOT_NEXT==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_NEXT_RANK_PAGE_BECAUSE_NOT_NEXT);
    }

    public List<String> getCHAT_SUCCESS_SHOW_RANK_PAGE() {
        if (CHAT_SUCCESS_SHOW_RANK_PAGE ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_SHOW_RANK_PAGE);
    }

    public List<String> getCHAT_SUCCESS_NEXT_ALL_MAP_PAGE() {
        if (CHAT_SUCCESS_NEXT_ALL_MAP_PAGE==null){
            return null;
        }  return new ArrayList<>(CHAT_SUCCESS_NEXT_ALL_MAP_PAGE);
    }

    public List<String> getCHAT_SUCCESS_NEXT_ALL_MEMBER_PAGE() {
        if (CHAT_SUCCESS_NEXT_ALL_MEMBER_PAGE==null){
            return null;
        } return new ArrayList<>(CHAT_SUCCESS_NEXT_ALL_MEMBER_PAGE);
    }

    public List<String> getCHAT_SUCCESS_NEXT_ALL_PARTY_PAGE() {
        if (CHAT_SUCCESS_NEXT_ALL_PARTY_PAGE==null){
            return null;
        }  return new ArrayList<>(CHAT_SUCCESS_NEXT_ALL_PARTY_PAGE);
    }

    public List<String> getCHAT_SUCCESS_NEXT_ALL_KIT_PAGE() {
        if (CHAT_SUCCESS_NEXT_ALL_KIT_PAGE==null){
            return null;
        }  return new ArrayList<>(CHAT_SUCCESS_NEXT_ALL_KIT_PAGE);
    }

    public List<String> getCHAT_SUCCESS_PREVIOUS_ALL_MAP_PAGE() {
        if (CHAT_SUCCESS_PREVIOUS_ALL_MAP_PAGE==null){
            return null;
        }  return new ArrayList<>(CHAT_SUCCESS_PREVIOUS_ALL_MAP_PAGE);
    }

    public List<String> getCHAT_SUCCESS_PREVIOUS_ALL_MEMBER_PAGE() {
        if (CHAT_SUCCESS_PREVIOUS_ALL_MEMBER_PAGE==null){
            return null;
        }   return new ArrayList<>(CHAT_SUCCESS_PREVIOUS_ALL_MEMBER_PAGE);
    }

    public List<String> getCHAT_SUCCESS_PREVIOUS_ALL_PARTY_PAGE() {
        if (CHAT_SUCCESS_PREVIOUS_ALL_PARTY_PAGE==null){
            return null;
        }  return new ArrayList<>(CHAT_SUCCESS_PREVIOUS_ALL_PARTY_PAGE);
    }

    public List<String> getCHAT_SUCCESS_PREVIOUS_ALL_KIT_PAGE() {
        if (CHAT_SUCCESS_PREVIOUS_ALL_KIT_PAGE==null){
            return null;
        }  return new ArrayList<>(CHAT_SUCCESS_PREVIOUS_ALL_KIT_PAGE);
    }

    public List<String> getCHAT_FAILURE_NEXT_ALL_MAP_PAGE_BECAUSE_NOT_NEXT() {
        if (CHAT_FAILURE_NEXT_ALL_MAP_PAGE_BECAUSE_NOT_NEXT==null){
            return null;
        }  return new ArrayList<>(CHAT_FAILURE_NEXT_ALL_MAP_PAGE_BECAUSE_NOT_NEXT);
    }

    public List<String> getCHAT_FAILURE_NEXT_ALL_MEMBER_PAGE_BECAUSE_NOT_NEXT() {
        if (CHAT_FAILURE_NEXT_ALL_MEMBER_PAGE_BECAUSE_NOT_NEXT==null){
            return null;
        }  return new ArrayList<>(CHAT_FAILURE_NEXT_ALL_MEMBER_PAGE_BECAUSE_NOT_NEXT);
    }

    public List<String> getCHAT_FAILURE_NEXT_ALL_PARTY_PAGE_BECAUSE_NOT_NEXT() {
        if (CHAT_FAILURE_NEXT_ALL_PARTY_PAGE_BECAUSE_NOT_NEXT==null){
            return null;
        } return new ArrayList<>(CHAT_FAILURE_NEXT_ALL_PARTY_PAGE_BECAUSE_NOT_NEXT);
    }

    public List<String> getCHAT_FAILURE_NEXT_ALL_KIT_PAGE_BECAUSE_NOT_NEXT() {
        if (CHAT_FAILURE_NEXT_ALL_KIT_PAGE_BECAUSE_NOT_NEXT==null){
            return null;
        } return new ArrayList<>(CHAT_FAILURE_NEXT_ALL_KIT_PAGE_BECAUSE_NOT_NEXT);
    }

    public List<String> getCHAT_FAILURE_PREVIOUS_ALL_MAP_PAGE_BECAUSE_NOT_PREVIOUS() {
        if (CHAT_FAILURE_PREVIOUS_ALL_MAP_PAGE_BECAUSE_NOT_PREVIOUS==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_PREVIOUS_ALL_MAP_PAGE_BECAUSE_NOT_PREVIOUS);
    }

    public List<String> getCHAT_FAILURE_PREVIOUS_ALL_MEMBER_PAGE_BECAUSE_NOT_PREVIOUS() {
        if (CHAT_FAILURE_PREVIOUS_ALL_MEMBER_PAGE_BECAUSE_NOT_PREVIOUS==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_PREVIOUS_ALL_MEMBER_PAGE_BECAUSE_NOT_PREVIOUS);
    }

    public List<String> getCHAT_FAILURE_PREVIOUS_ALL_PARTY_PAGE_BECAUSE_NOT_PREVIOUS() {
        if (CHAT_FAILURE_PREVIOUS_ALL_PARTY_PAGE_BECAUSE_NOT_PREVIOUS==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_PREVIOUS_ALL_PARTY_PAGE_BECAUSE_NOT_PREVIOUS);
    }







    public List<String> getCHAT_FAILURE_PREVIOUS_ALL_KIT_PAGE_BECAUSE_NOT_PREVIOUS() {
        if (CHAT_FAILURE_PREVIOUS_ALL_KIT_PAGE_BECAUSE_NOT_PREVIOUS==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_PREVIOUS_ALL_KIT_PAGE_BECAUSE_NOT_PREVIOUS);
    }

    public List<String> getCHAT_SUCCESS_NOTIFY_VERSION() {
        if (CHAT_SUCCESS_NOTIFY_VERSION ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_NOTIFY_VERSION);
    }

    public List<String> getCHAT_SUCCESS_CHOOSE_KIT() {
        if (CHAT_SUCCESS_CHOOSE_KIT==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_CHOOSE_KIT);
    }

    public List<String> getCHAT_SUCCESS_STOP_CHOOSE_KIT() {
        if (CHAT_SUCCESS_STOP_CHOOSE_KIT==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_STOP_CHOOSE_KIT);
    }

    public List<String> getCHAT_SUCCESS_BACK_ALL_MEMBER_PAGE() {

        if (CHAT_SUCCESS_BACK_ALL_MEMBER_PAGE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_BACK_ALL_MEMBER_PAGE);
    }

    public List<String> getCHAT_SUCCESS_SHOW_ALL_MAP_PAGE() {
        if (CHAT_SUCCESS_SHOW_ALL_MAP_PAGE ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_SHOW_ALL_MAP_PAGE);
    }

    public List<String> getCHAT_SUCCESS_LEAVE_PARTY() {
        if (CHAT_SUCCESS_LEAVE_PARTY==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_LEAVE_PARTY);
    }

    public List<String> getCHAT_SUCCESS_KICK_MEMBER() {
        if (CHAT_SUCCESS_KICK_MEMBER==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_KICK_MEMBER);
    }

    public List<String> getCHAT_SUCCESS_BACK_ALL_PARTY_PAGE() {
        if (CHAT_SUCCESS_BACK_ALL_PARTY_PAGE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_BACK_ALL_PARTY_PAGE);
    }

    public List<String> getCHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_RANK_PAGE() {
        if (CHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_RANK_PAGE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_RANK_PAGE);
    }

    public List<String> getCHAT_SUCCESS_SHOW_ALL_MEMBER_PAGE() {
        if (CHAT_SUCCESS_SHOW_ALL_MEMBER_PAGE ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_SHOW_ALL_MEMBER_PAGE);
    }

    public List<String> getCHAT_SUCCESS_CANCEL_CREATE_PARTY() {
        if (CHAT_SUCCESS_CANCEL_CREATE_PARTY==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_CANCEL_CREATE_PARTY);
    }

    public String getINPUT_CANCEL() {
        return INPUT_CANCEL;
    }

    public List<String> getCHAT_SUCCESS_OPEN_GUI() {
        if (CHAT_SUCCESS_OPEN_GUI ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_OPEN_GUI);
    }

    public List<String> getCHAT_SUCCESS_RESET_SEASON() {
        if (CHAT_SUCCESS_RESET_SEASON ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_RESET_SEASON);
    }

    public List<String> getCHAT_FAILURE_CREATE_PARTY_BECAUSE_DUPLICATE_PARTY_NAME() {
        if (CHAT_FAILURE_CREATE_PARTY_BECAUSE_DUPLICATE_PARTY_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_CREATE_PARTY_BECAUSE_DUPLICATE_PARTY_NAME);
    }

    public List<String> getCHAT_HOW_TO_CREATE_PARTY() {
        if (CHAT_HOW_TO_CREATE_PARTY==null){
            return null;
        }return new ArrayList<>(CHAT_HOW_TO_CREATE_PARTY);
    }

    public List<String> getCHAT_NOT_PLAYER() {
        if (CHAT_NOT_PLAYER==null){
            return null;
        }return new ArrayList<>(CHAT_NOT_PLAYER);
    }

    public List<String> getCHAT_NO_PERMISSION() {
        if (CHAT_NO_PERMISSION==null){
            return null;
        }return new ArrayList<>(CHAT_NO_PERMISSION);
    }
    public List<String> getCHAT_SUCCESS_SET_MAP_CHOOSE_TIME() {

        if (CHAT_SUCCESS_SET_MAP_CHOOSE_TIME ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_SET_MAP_CHOOSE_TIME);
    }

    public List<String> getCHAT_FAILURE_SET_MAP_CHOOSE_TIME_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_SET_MAP_CHOOSE_TIME_BECAUSE_NOT_EXIST_MAP_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_SET_MAP_CHOOSE_TIME_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_SOMEONE_SUCCESS_RACE_STOP_NOT_DRAW() {
        if (CHAT_SOMEONE_SUCCESS_RACE_STOP_NOT_DRAW==null){
            return null;
        }return new ArrayList<>(CHAT_SOMEONE_SUCCESS_RACE_STOP_NOT_DRAW);
    }

    public List<String> getCHAT_SOMEONE_SUCCESS_RACE_STOP_DRAW() {
        if (CHAT_SOMEONE_SUCCESS_RACE_STOP_DRAW==null){
            return null;
        }return new ArrayList<>(CHAT_SOMEONE_SUCCESS_RACE_STOP_DRAW);
    }

    public List<String> getCHAT_SUCCESS_START_RACE() {
        if (CHAT_SUCCESS_START_RACE ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_START_RACE);
    }

    public List<String> getCHAT_FAILURE_JOIN_PARTY_BECAUSE_PARTY_IS_MATCHING() {
        if (CHAT_FAILURE_JOIN_PARTY_BECAUSE_PARTY_IS_MATCHING==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_JOIN_PARTY_BECAUSE_PARTY_IS_MATCHING);
    }

    public List<String> getCHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_NOT_AVAILABLE_MAP() {
        if (CHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_NOT_AVAILABLE_MAP==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_NOT_AVAILABLE_MAP);
    }

    public List<String> getCHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_NOT_CAPTAIN() {
        if (CHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_NOT_CAPTAIN==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_NOT_CAPTAIN);
    }

    public List<String> getCHAT_FAILURE_START_SPECIFIC_MATCH_BECAUSE_NOT_CAPTAIN() {
        if (CHAT_FAILURE_START_SPECIFIC_MATCH_BECAUSE_NOT_CAPTAIN==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_START_SPECIFIC_MATCH_BECAUSE_NOT_CAPTAIN);
    }

    public List<String> getCHAT_FAILURE_CANCEL_MATCH_BECAUSE_PARTY_IS_NOT_MATCHING() {
        if (CHAT_FAILURE_CANCEL_MATCH_BECAUSE_PARTY_IS_NOT_MATCHING==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_CANCEL_MATCH_BECAUSE_PARTY_IS_NOT_MATCHING);
    }

    public List<String> getCHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_PARTY_IS_MATCHING() {
        if (CHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_PARTY_IS_MATCHING==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_START_RANDOM_MATCH_BECAUSE_PARTY_IS_MATCHING);
    }

    public List<String> getCHAT_FAILURE_START_SPECIFIC_MATCH_BECAUSE_PARTY_IS_MATCHING() {
        if (CHAT_FAILURE_START_SPECIFIC_MATCH_BECAUSE_PARTY_IS_MATCHING==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_START_SPECIFIC_MATCH_BECAUSE_PARTY_IS_MATCHING);
    }

    public List<String> getCHAT_SUCCESS_START_RANDOM_MATCH() {
        if (CHAT_SUCCESS_START_RANDOM_MATCH==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_START_RANDOM_MATCH);
    }

    public List<String> getCHAT_SOMEONE_SUCCESS_START_RANDOM_MATCH() {
        if (CHAT_SOMEONE_SUCCESS_START_RANDOM_MATCH==null){
            return null;
        }return new ArrayList<>(CHAT_SOMEONE_SUCCESS_START_RANDOM_MATCH);
    }

    public List<String> getCHAT_SUCCESS_CANCEL_MATCH() {
        if (CHAT_SUCCESS_CANCEL_MATCH==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_CANCEL_MATCH);
    }

    public List<String> getCHAT_SOMEONE_SUCCESS_CANCEL_MATCH() {
        if (CHAT_SOMEONE_SUCCESS_CANCEL_MATCH==null){
            return null;
        }return new ArrayList<>(CHAT_SOMEONE_SUCCESS_CANCEL_MATCH);
    }

    public List<String> getCHAT_SUCCESS_START_SPECIFIC_MATCH() {
        if (CHAT_SUCCESS_START_SPECIFIC_MATCH==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_START_SPECIFIC_MATCH);
    }

    public List<String> getCHAT_SOMEONE_SUCCESS_START_SPECIFIC_MATCH() {
        if (CHAT_SOMEONE_SUCCESS_START_SPECIFIC_MATCH==null){
            return null;
        }return new ArrayList<>(CHAT_SOMEONE_SUCCESS_START_SPECIFIC_MATCH);
    }

    public List<String> getCHAT_FAILURE_LEAVE_PARTY_BECAUSE_PARTY_IS_MATCHING() {
        if (CHAT_FAILURE_LEAVE_PARTY_BECAUSE_PARTY_IS_MATCHING==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_LEAVE_PARTY_BECAUSE_PARTY_IS_MATCHING);
    }

    public List<String> getCHAT_FAILURE_KICK_MEMBER_BECAUSE_PARTY_IS_MATCHING() {
        if (CHAT_FAILURE_KICK_MEMBER_BECAUSE_PARTY_IS_MATCHING==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_KICK_MEMBER_BECAUSE_PARTY_IS_MATCHING);
    }

    public List<String> getCHAT_SUCCESS_WAS_KICKED_PARTY() {

        if (CHAT_SUCCESS_WAS_KICKED_PARTY==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_WAS_KICKED_PARTY);
    }

    public List<String> getCHAT_SOMEONE_SUCCESS_WAS_KICKED_PARTY() {
        if (CHAT_SOMEONE_SUCCESS_WAS_KICKED_PARTY==null){
            return null;
        }return new ArrayList<>(CHAT_SOMEONE_SUCCESS_WAS_KICKED_PARTY);
    }

    public List<String> getCHAT_SOMEONE_SUCCESS_LEAVE_PARTY() {
        if (CHAT_SOMEONE_SUCCESS_LEAVE_PARTY==null){
            return null;
        }return new ArrayList<>(CHAT_SOMEONE_SUCCESS_LEAVE_PARTY);
    }

    public List<String> getCHAT_SOMEONE_SUCCESS_JOIN_PARTY() {
        if (CHAT_SOMEONE_SUCCESS_JOIN_PARTY==null){
            return null;
        }return new ArrayList<>(CHAT_SOMEONE_SUCCESS_JOIN_PARTY);
    }

    public List<String> getCHAT_SUCCESS_ADD_MAP_DESCRIPTION() {
        if (CHAT_SUCCESS_ADD_MAP_DESCRIPTION ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_ADD_MAP_DESCRIPTION);
    }

    public List<String> getCHAT_FAILURE_ADD_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_ADD_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_ADD_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_KICK_MEMBER_BECAUSE_NOT_CAPTAIN() {
        if (CHAT_FAILURE_KICK_MEMBER_BECAUSE_NOT_CAPTAIN==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_KICK_MEMBER_BECAUSE_NOT_CAPTAIN);
    }

    public List<String> getCHAT_FAILURE_SHOW_ALL_MEMBER_PAGE_BECAUSE_NOT_JOIN_PARTY() {
        if (CHAT_FAILURE_SHOW_ALL_MEMBER_PAGE_BECAUSE_NOT_JOIN_PARTY ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_SHOW_ALL_MEMBER_PAGE_BECAUSE_NOT_JOIN_PARTY);
    }

    public List<String> getCHAT_FAILURE_JOIN_PARTY_BECAUSE_ALREADY_JOIN_PARTY() {
        if (CHAT_FAILURE_JOIN_PARTY_BECAUSE_ALREADY_JOIN_PARTY==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_JOIN_PARTY_BECAUSE_ALREADY_JOIN_PARTY);
    }

    public List<String> getCHAT_SUCCESS_JOIN_PARTY() {
        if (CHAT_SUCCESS_JOIN_PARTY==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_JOIN_PARTY);
    }

    public List<String> getCHAT_FAILURE_CREATE_PARTY_BECAUSE_ALREADY_JOIN_PARTY() {
        if (CHAT_FAILURE_CREATE_PARTY_BECAUSE_ALREADY_JOIN_PARTY==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_CREATE_PARTY_BECAUSE_ALREADY_JOIN_PARTY);
    }

    public List<String> getCHAT_FAILURE_CREATE_PARTY_BECAUSE_IN_WATCHING() {

        if (CHAT_FAILURE_CREATE_PARTY_BECAUSE_IN_WATCHING==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_CREATE_PARTY_BECAUSE_IN_WATCHING);
    }

    public List<String> getCHAT_SUCCESS_CREATE_PARTY() {
        if (CHAT_SUCCESS_CREATE_PARTY==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_CREATE_PARTY);
    }

    public List<String> getCHAT_SUCCESS_ADD_KIT_DESCRIPTION() {
        if (CHAT_SUCCESS_ADD_KIT_DESCRIPTION ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_ADD_KIT_DESCRIPTION);
    }

    public List<String> getCHAT_FAILURE_ADD_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME() {
        if (CHAT_FAILURE_ADD_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_ADD_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME);
    }

    public List<String> getCHAT_FAILURE_REMOVE_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME() {
        if (CHAT_FAILURE_REMOVE_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_REMOVE_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME);
    }

    public List<String> getCHAT_FAILURE_REMOVE_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW() {
        if (CHAT_FAILURE_REMOVE_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_REMOVE_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW);
    }

    public List<String> getCHAT_SUCCESS_KIT_DESCRIPTION_REMOVE() {
        if (CHAT_SUCCESS_KIT_DESCRIPTION_REMOVE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_KIT_DESCRIPTION_REMOVE);
    }

    public List<String> getCHAT_FAILURE_SET_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME() {
        if (CHAT_FAILURE_SET_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_SET_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_KIT_NAME);
    }

    public List<String> getCHAT_FAILURE_SET_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW() {
        if (CHAT_FAILURE_SET_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_SET_KIT_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW);
    }

    public List<String> getCHAT_SUCCESS_SET_KIT_DESCRIPTION() {
        if (CHAT_SUCCESS_SET_KIT_DESCRIPTION ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_SET_KIT_DESCRIPTION);
    }

    public List<String> getCHAT_SUCCESS_REMOVE_MAP_KIT() {
        if (CHAT_SUCCESS_REMOVE_MAP_KIT ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_REMOVE_MAP_KIT);
    }

    public List<String> getCHAT_FAILURE_REMOVE_MAP_KIT_BECAUSE_NOT_EXIST_KIT_NAME() {
        if (CHAT_FAILURE_REMOVE_MAP_KIT_BECAUSE_NOT_EXIST_KIT_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_REMOVE_MAP_KIT_BECAUSE_NOT_EXIST_KIT_NAME);
    }

    public List<String> getCHAT_FAILURE_REMOVE_MAP_KIT_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_REMOVE_MAP_KIT_BECAUSE_NOT_EXIST_MAP_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_REMOVE_MAP_KIT_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_REMOVE_MAP_KIT_BECAUSE_MAP_NOT_ADD_KIT() {
        if (CHAT_FAILURE_REMOVE_MAP_KIT_BECAUSE_MAP_NOT_ADD_KIT ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_REMOVE_MAP_KIT_BECAUSE_MAP_NOT_ADD_KIT);
    }

    public List<String> getCHAT_SUCCESS_ADD_MAP_KIT() {
        if (CHAT_SUCCESS_ADD_MAP_KIT ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_ADD_MAP_KIT);
    }

    public List<String> getCHAT_FAILURE_ADD_MAP_KIT_BECAUSE_NOT_EXIST_KIT_NAME() {
        if (CHAT_FAILURE_ADD_MAP_KIT_BECAUSE_NOT_EXIST_KIT_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_ADD_MAP_KIT_BECAUSE_NOT_EXIST_KIT_NAME);
    }

    public List<String> getCHAT_FAILURE_ADD_MAP_KIT_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_ADD_MAP_KIT_BECAUSE_NOT_EXIST_MAP_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_ADD_MAP_KIT_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_ADD_MAP_KIT_BECAUSE_MAP_ALREADY_ADD_KIT() {
        if (CHAT_FAILURE_ADD_MAP_KIT_BECAUSE_MAP_ALREADY_ADD_KIT ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_ADD_MAP_KIT_BECAUSE_MAP_ALREADY_ADD_KIT);
    }

    public List<String> getCHAT_SUCCESS_SET_KIT() {
        if (CHAT_SUCCESS_SET_KIT ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_SET_KIT);
    }

    public List<String> getCHAT_FAILURE_SET_KIT_BECAUSE_NOT_EXIST_KIT_NAME() {
        if (CHAT_FAILURE_SET_KIT_BECAUSE_NOT_EXIST_KIT_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_SET_KIT_BECAUSE_NOT_EXIST_KIT_NAME);
    }

    public List<String> getCHAT_SUCCESS_DELETE_KIT() {
        if (CHAT_SUCCESS_DELETE_KIT ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_DELETE_KIT);
    }

    public List<String> getCHAT_FAILURE_DELETE_KIT_BECAUSE_NOT_EXIST_KIT_NAME() {
        if (CHAT_FAILURE_DELETE_KIT_BECAUSE_NOT_EXIST_KIT_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_DELETE_KIT_BECAUSE_NOT_EXIST_KIT_NAME);
    }

    public List<String> getCHAT_SUCCESS_CREATE_KIT() {
        if (CHAT_SUCCESS_CREATE_KIT ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_CREATE_KIT);
    }

    public List<String> getCHAT_FAILURE_CREATE_KIT_BECAUSE_DUPLICATE_KIT_NAME() {
        if (CHAT_FAILURE_CREATE_KIT_BECAUSE_DUPLICATE_KIT_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_CREATE_KIT_BECAUSE_DUPLICATE_KIT_NAME);
    }

    public List<String> getCHAT_SUCCESS_SET_MAP_BUILD() {
        if (CHAT_SUCCESS_SET_MAP_BUILD ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_SET_MAP_BUILD);
    }

    public List<String> getCHAT_SUCCESS_SET_MAP_FAIR() {
        if (CHAT_SUCCESS_SET_MAP_FAIR ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_SET_MAP_FAIR);
    }

    public List<String> getCHAT_SUCCESS_SET_MAP_SCALE() {
        if (CHAT_SUCCESS_SET_MAP_SCALE ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_SET_MAP_SCALE);
    }

    public List<String> getCHAT_SUCCESS_SET_MAP_KEEP_INVENTORY() {
        if (CHAT_SUCCESS_SET_MAP_KEEP_INVENTORY ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_SET_MAP_KEEP_INVENTORY);
    }

    public List<String> getCHAT_FAILURE_SET_MAP_FAIR_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_SET_MAP_FAIR_BECAUSE_NOT_EXIST_MAP_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_SET_MAP_FAIR_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_SET_MAP_BUILD_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_SET_MAP_BUILD_BECAUSE_NOT_EXIST_MAP_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_SET_MAP_BUILD_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_SET_MAP_KEEP_INVENTORY_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_SET_MAP_KEEP_INVENTORY_BECAUSE_NOT_EXIST_MAP_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_SET_MAP_KEEP_INVENTORY_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_SET_MAP_SCALE_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_SET_MAP_SCALE_BECAUSE_NOT_EXIST_MAP_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_SET_MAP_SCALE_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_SET_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_SET_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_SET_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_SET_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW() {
        if (CHAT_FAILURE_SET_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_SET_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW);
    }

    public List<String> getCHAT_SUCCESS_SET_MAP_DESCRIPTION() {
        if (CHAT_SUCCESS_SET_MAP_DESCRIPTION ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_SET_MAP_DESCRIPTION);
    }

    public List<String> getCHAT_FAILURE_MAP_REMOVE_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_MAP_REMOVE_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_REMOVE_DESCRIPTION_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_REMOVE_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW() {
        if (CHAT_FAILURE_REMOVE_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_REMOVE_MAP_DESCRIPTION_BECAUSE_NOT_EXIST_DESCRIPTION_ROW);
    }

    public List<String> getCHAT_SUCCESS_REMOVE_MAP_DESCRIPTION() {
        if (CHAT_SUCCESS_REMOVE_MAP_DESCRIPTION ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_REMOVE_MAP_DESCRIPTION);
    }

    public List<String> getCHAT_SUCCESS_SET_SECTION() {
        if (CHAT_SUCCESS_SET_SECTION ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_SET_SECTION);
    }

    public List<String> getCHAT_INVALID_ARGUMENT() {
        if (CHAT_INVALID_ARGUMENT==null){
            return null;
        }return new ArrayList<>(CHAT_INVALID_ARGUMENT);
    }
    public List<String> getCHAT_FAILURE_DELETE_MAP_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_DELETE_MAP_BECAUSE_NOT_EXIST_MAP_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_DELETE_MAP_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_SUCCESS_DELETE_MAP() {
        if (CHAT_SUCCESS_DELETE_MAP ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_DELETE_MAP);
    }

    public List<String> getCHAT_FAILURE_CREATE_MAP_BECAUSE_DUPLICATE_MAP_NAME() {
        if (CHAT_FAILURE_CREATE_MAP_BECAUSE_DUPLICATE_MAP_NAME ==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_CREATE_MAP_BECAUSE_DUPLICATE_MAP_NAME);
    }

    public List<String> getCHAT_SUCCESS_CREATE_MAP() {
        if (CHAT_SUCCESS_CREATE_MAP ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_CREATE_MAP);
    }

    public List<String> getCHAT_FAILURE_MAP_CREATE_BECAUSE_INVALID_FOUR_POINT() {
        if (CHAT_FAILURE_MAP_CREATE_BECAUSE_INVALID_FOUR_POINT==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_CREATE_BECAUSE_INVALID_FOUR_POINT);
    }

    public List<String> getCHAT_FAILURE_MAP_CREATE_BECAUSE_NOT_FOUR_POINT() {
        if (CHAT_FAILURE_MAP_CREATE_BECAUSE_NOT_FOUR_POINT==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_CREATE_BECAUSE_NOT_FOUR_POINT);
    }

    public List<String> getCHAT_SUCCESS_RELOAD_YAML() {
        if (CHAT_SUCCESS_RELOAD_YAML ==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_RELOAD_YAML);
    }

    public List<String> getCHAT_SUCCESS_CORRECT_YAML() {
        if (CHAT_SUCCESS_CORRECT_YAML==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_CORRECT_YAML);
    }
    public List<String> getCHAT_SUCCESS_HELP() {
        if (CHAT_SUCCESS_HELP==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_HELP);
    }

}
