package pers.zhangyang.easypvp.yaml;

import pers.zhangyang.easypvp.base.YamlManagerBase;

import java.util.ArrayList;
import java.util.List;

public class MessageYaml extends YamlManagerBase {
    public static final MessageYaml MESSAGE_YAML_MANAGER =new MessageYaml();

    private MessageYaml( ) {
        super("language/"+ SettingYaml.SETTING_YAML_MANAGER.getLANGUAGE()+"/message.yml");
    }

    private String INPUT_CANCEL;
    private List<String> CHAT_NOT_PLAYER;
    private List<String> CHAT_NO_PERMISSION;

    private List<String> CHAT_SUCCESS_CORRECT_YAML;
    private List<String> CHAT_SUCCESS_RECORD_RESET;
    private List<String> CHAT_SUCCESS_RELOAD;
    private List<String> CHAT_SUCCESS_HELP;
    private List<String> CHAT_SUCCESS_CANCEL_CREATE_PARTY;
    private List<String> CHAT_SUCCESS_GUI;
    private List<String> CHAT_SUCCESS_SECTION_SET;

    private List<String> CHAT_INVALID_ARGUMENT;
    private List<String> CHAT_FAILURE_MAP_CREATE_BECAUSE_INVALID_FOUR_POINT;

    private List<String> CHAT_FAILURE_MAP_CREATE_BECAUSE_NOT_FOUR_POINT;
    private List<String> CHAT_SUCCESS_MAP_CREATE;

    private List<String> CHAT_FAILURE_JOIN_PARTY_BECAUSE_PARTY_IS_RACING;

    private List<String> CHAT_FAILURE_JOIN_PARTY_BECAUSE_IN_WATCHING;
    private List<String> CHAT_SUCCESS_MAP_DELETE;

    private List<String> CHAT_FAILURE_MAP_DELETE_BECAUSE_NOT_EXIST_MAP_NAME;
    private List<String> CHAT_FAILURE_MAP_CREATE_BECAUSE_DUPLICATE_MAP_NAME;

    private List<String> CHAT_SUCCESS_MAP_CHOOSE_TICK_SET;

    private List<String> CHAT_FAILURE_MAP_CHOOSE_TICK_SET_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_SUCCESS_MAP_DESCRIPTION_ADD;

    private List<String> CHAT_FAILURE_MAP_DESCRIPTION_ADD_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_FAILURE_MAP_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_FAILURE_MAP_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_DESCRIPTION_ROW;

    private List<String> CHAT_SUCCESS_MAP_DESCRIPTION_REMOVE;

    private List<String> CHAT_FAILURE_MAP_DESCRIPTION_SET_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_FAILURE_MAP_DESCRIPTION_SET_BECAUSE_NOT_EXIST_DESCRIPTION_ROW;

    private List<String> CHAT_SUCCESS_MAP_DESCRIPTION_SET;

    private List<String> CHAT_VERSION_NOTIFY;

    private List<String> CHAT_SUCCESS_MAP_BUILD_SET;
    private List<String> CHAT_SUCCESS_MAP_FAIR_SET;
    private List<String> CHAT_SUCCESS_MAP_SCALE_SET;
    private List<String> CHAT_SUCCESS_MAP_DROP_SET;

    private List<String> CHAT_SUCCESS_LEAVE_PARTY;
    private List<String> CHAT_FAILURE_MAP_FAIR_SET_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_FAILURE_MAP_BUILD_SET_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_FAILURE_MAP_DROP_SET_BECAUSE_NOT_EXIST_MAP_NAME;
    private List<String> CHAT_FAILURE_MAP_SCALE_SET_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_SUCCESS_KIT_CREATE;

    private List<String> CHAT_FAILURE_KIT_CREATE_BECAUSE_DUPLICATE_KIT_NAME;

    private List<String> CHAT_SUCCESS_KIT_DELETE;

    private List<String> CHAT_FAILURE_KIT_DELETE_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_SUCCESS_KIT_SET;

    private List<String> CHAT_FAILURE_KIT_SET_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_SUCCESS_MAP_KIT_ADD;

    private List<String> CHAT_FAILURE_MAP_KIT_ADD_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_FAILURE_MAP_KIT_ADD_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_FAILURE_MAP_KIT_ADD_BECAUSE_MAP_ALREADY_ADD_KIT;

    private List<String> CHAT_SUCCESS_SHOW_ALL_MEMBER_PAGE;
    private List<String> CHAT_SUCCESS_MAP_KIT_REMOVE;

    private List<String> CHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_MAP_NOT_ADD_KIT;

    private List<String> CHAT_SUCCESS_KIT_DESCRIPTION_ADD;
    private List<String> CHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_MATCHING;

    public List<String> getCHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_MATCHING() {
        if (CHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_MATCHING==null){
            return null;
        }
        return new ArrayList<>(CHAT_SOMEONE_SUCCESS_QUIT_GAME_IN_MATCHING);
    }

    private List<String> CHAT_FAILURE_KIT_DESCRIPTION_ADD_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_FAILURE_KIT_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_FAILURE_KIT_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_DESCRIPTION_ROW;

    private List<String> CHAT_SUCCESS_KIT_DESCRIPTION_REMOVE;

    private List<String> CHAT_FAILURE_KIT_DESCRIPTION_SET_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_FAILURE_KIT_DESCRIPTION_SET_BECAUSE_NOT_EXIST_DESCRIPTION_ROW;

    private List<String> CHAT_SUCCESS_KIT_DESCRIPTION_SET;
    private List<String> CHAT_FAILURE_CREATE_PARTY_BECAUSE_ALREADY_JOIN_PARTY;

    private List<String> CHAT_FAILURE_CREATE_PARTY_BECAUSE_IN_WATCHING;
    private List<String> CHAT_SUCCESS_CREATE_PARTY;

    private List<String> CHAT_FAILURE_JOIN_PARTY_BECAUSE_ALREADY_JOIN_PARTY;

    private List<String> CHAT_FAILURE_KICK_MEMBER_BECAUSE_NOT_CAPTAIN;

    private List<String> CHAT_SUCCESS_JOIN_PARTY;
    private List<String> CHAT_SOMEONE_SUCCESS_JOIN_PARTY;
    private List<String> CHAT_SOMEONE_SUCCESS_LEAVE_PARTY;
    private List<String> CHAT_SOMEONE_SUCCESS_WAS_KICKED_PARTY;


    private List<String> CHAT_SUCCESS_RANK_PAGE;

    private List<String> CHAT_SUCCESS_WAS_KICKED_PARTY;

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

    private List<String> CHAT_SUCCESS_RACE_START;
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
    private List<String> COMPLETER_EASY_PVP_KIT_CREATE;
    private List<String> COMPLETER_EASY_PVP_KIT_DELETE;
    private List<String> COMPLETER_EASY_PVP_KIT_DESCRIPTION_ADD;
    private List<String> COMPLETER_EASY_PVP_KIT_DESCRIPTION_ADD_$;
    private List<String> COMPLETER_EASY_PVP_KIT_DESCRIPTION_REMOVE_$;
    private List<String> COMPLETER_EASY_PVP_KIT_DESCRIPTION_REMOVE;

    private List<String> COMPLETER_EASY_PVP_KIT_DESCRIPTION_SET_$_$;
    private List<String> COMPLETER_EASY_PVP_KIT_DESCRIPTION_SET_$;
    private List<String> COMPLETER_EASY_PVP_KIT_DESCRIPTION_SET;
    private List<String> COMPLETER_EASY_PVP_KIT_SET;
    private List<String> COMPLETER_EASY_PVP_MAP_BUILD_SET;
    private List<String> COMPLETER_EASY_PVP_MAP_BUILD_SET_$;
    private List<String> COMPLETER_EASY_PVP_MAP_CHOOSE_TICK_SET;
    private List<String> COMPLETER_EASY_PVP_MAP_CHOOSE_TICK_SET_$;
    private List<String> COMPLETER_EASY_PVP_MAP_CREATE;
    private List<String> COMPLETER_EASY_PVP_MAP_DELETE;
    private List<String> COMPLETER_EASY_PVP_MAP_DESCRIPTION_ADD;
    private List<String> COMPLETER_EASY_PVP_MAP_DESCRIPTION_ADD_$;

    private List<String> COMPLETER_EASY_PVP_MAP_DESCRIPTION_REMOVE;
    private List<String> COMPLETER_EASY_PVP_MAP_DESCRIPTION_REMOVE_$;

    private List<String> COMPLETER_EASY_PVP_MAP_DESCRIPTION_SET;
    private List<String> COMPLETER_EASY_PVP_MAP_DESCRIPTION_SET_$;

    private List<String> COMPLETER_EASY_PVP_MAP_DESCRIPTION_SET_$_$;
    private List<String> COMPLETER_EASY_PVP_MAP_DROP_SET;
    private List<String> COMPLETER_EASY_PVP_MAP_DROP_SET_$;

    private List<String> COMPLETER_EASY_PVP_MAP_FAIR_SET;
    private List<String> COMPLETER_EASY_PVP_MAP_FAIR_SET_$;


    private List<String> COMPLETER_EASY_PVP_MAP_SCALE_SET;
    private List<String> COMPLETER_EASY_PVP_MAP_SCALE_SET_$;


    private List<String> COMPLETER_EASY_PVP_MAP_KIT_ADD;
    private List<String> COMPLETER_EASY_PVP_MAP_KIT_ADD_$;

    private List<String> COMPLETER_EASY_PVP_MAP_KIT_REMOVE;
    private List<String> COMPLETER_EASY_PVP_MAP_KIT_REMOVE_$;

    private List<String> COMPLETER_EASY_PVP_SECTION_SET;


    public List<String> getCOMPLETER_EASY_PVP() {
        if (COMPLETER_EASY_PVP==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP);
    }

    public List<String> getCOMPLETER_EASY_PVP_KIT_CREATE() {
        if (COMPLETER_EASY_PVP_KIT_CREATE==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_KIT_CREATE);
    }

    public List<String> getCOMPLETER_EASY_PVP_KIT_DELETE() {
        if (COMPLETER_EASY_PVP_KIT_DELETE==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_KIT_DELETE);
    }

    public List<String> getCOMPLETER_EASY_PVP_KIT_DESCRIPTION_ADD() {
        if (COMPLETER_EASY_PVP_KIT_DESCRIPTION_ADD==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_KIT_DESCRIPTION_ADD);
    }

    public List<String> getCOMPLETER_EASY_PVP_KIT_DESCRIPTION_ADD_$() {
        if (COMPLETER_EASY_PVP_KIT_DESCRIPTION_ADD_$==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_KIT_DESCRIPTION_ADD_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_KIT_DESCRIPTION_REMOVE_$() {
        if (COMPLETER_EASY_PVP_KIT_DESCRIPTION_REMOVE_$==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_KIT_DESCRIPTION_REMOVE_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_KIT_DESCRIPTION_REMOVE() {
        if (COMPLETER_EASY_PVP_KIT_DESCRIPTION_REMOVE==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_KIT_DESCRIPTION_REMOVE);
    }

    public List<String> getCOMPLETER_EASY_PVP_KIT_DESCRIPTION_SET_$() {
        if (COMPLETER_EASY_PVP_KIT_DESCRIPTION_SET_$==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_KIT_DESCRIPTION_SET_$);
    }
    public List<String> getCOMPLETER_EASY_PVP_KIT_DESCRIPTION_SET_$_$() {
        if (COMPLETER_EASY_PVP_KIT_DESCRIPTION_SET_$_$==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_KIT_DESCRIPTION_SET_$_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_KIT_DESCRIPTION_SET() {
        if (COMPLETER_EASY_PVP_KIT_DESCRIPTION_SET==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_KIT_DESCRIPTION_SET);
    }

    public List<String> getCOMPLETER_EASY_PVP_KIT_SET() {
        if (COMPLETER_EASY_PVP_KIT_SET==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_KIT_SET);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_BUILD_SET() {
        if (COMPLETER_EASY_PVP_MAP_BUILD_SET==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_BUILD_SET);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_BUILD_SET_$() {
        if (COMPLETER_EASY_PVP_MAP_BUILD_SET_$==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_BUILD_SET_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_CHOOSE_TICK_SET() {
        if (COMPLETER_EASY_PVP_MAP_CHOOSE_TICK_SET==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_CHOOSE_TICK_SET);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_CHOOSE_TICK_SET_$() {
        if (COMPLETER_EASY_PVP_MAP_CHOOSE_TICK_SET_$==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_CHOOSE_TICK_SET_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_CREATE() {
        if (COMPLETER_EASY_PVP_MAP_CREATE==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_CREATE);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_DELETE() {
        if (COMPLETER_EASY_PVP_MAP_DELETE==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_DELETE);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_DESCRIPTION_ADD() {
        if (COMPLETER_EASY_PVP_MAP_DESCRIPTION_ADD==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_DESCRIPTION_ADD);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_DESCRIPTION_ADD_$() {
        if (COMPLETER_EASY_PVP_MAP_DESCRIPTION_ADD_$==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_DESCRIPTION_ADD_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_DESCRIPTION_REMOVE() {
        if (COMPLETER_EASY_PVP_MAP_DESCRIPTION_REMOVE==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_DESCRIPTION_REMOVE);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_DESCRIPTION_REMOVE_$() {
        if (COMPLETER_EASY_PVP_MAP_DESCRIPTION_REMOVE_$==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_DESCRIPTION_REMOVE_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_DESCRIPTION_SET() {
        if (COMPLETER_EASY_PVP_MAP_DESCRIPTION_SET==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_DESCRIPTION_SET);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_DESCRIPTION_SET_$() {
        if (COMPLETER_EASY_PVP_MAP_DESCRIPTION_SET_$==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_DESCRIPTION_SET_$);
    }
    public List<String> getCOMPLETER_EASY_PVP_MAP_DESCRIPTION_SET_$_$() {
        if (COMPLETER_EASY_PVP_MAP_DESCRIPTION_SET_$_$==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_DESCRIPTION_SET_$_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_DROP_SET() {
        if (COMPLETER_EASY_PVP_MAP_DROP_SET==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_DROP_SET);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_DROP_SET_$() {
        if (COMPLETER_EASY_PVP_MAP_DROP_SET_$==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_DROP_SET_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_FAIR_SET() {
        if (COMPLETER_EASY_PVP_MAP_FAIR_SET==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_FAIR_SET);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_FAIR_SET_$() {
        if (COMPLETER_EASY_PVP_MAP_FAIR_SET_$==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_FAIR_SET_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_SCALE_SET() {
        if (COMPLETER_EASY_PVP_MAP_SCALE_SET==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_SCALE_SET);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_SCALE_SET_$() {
        if (COMPLETER_EASY_PVP_MAP_SCALE_SET_$==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_SCALE_SET_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_KIT_ADD() {
        if (COMPLETER_EASY_PVP_MAP_KIT_ADD==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_KIT_ADD);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_KIT_ADD_$() {
        if (COMPLETER_EASY_PVP_MAP_KIT_ADD_$==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_KIT_ADD_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_KIT_REMOVE() {
        if (COMPLETER_EASY_PVP_MAP_KIT_REMOVE==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_KIT_REMOVE);
    }

    public List<String> getCOMPLETER_EASY_PVP_MAP_KIT_REMOVE_$() {
        if (COMPLETER_EASY_PVP_MAP_KIT_REMOVE_$==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_MAP_KIT_REMOVE_$);
    }

    public List<String> getCOMPLETER_EASY_PVP_SECTION_SET() {
        if (COMPLETER_EASY_PVP_SECTION_SET==null){
            return null;
        } return new ArrayList<>(COMPLETER_EASY_PVP_SECTION_SET);
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

    @Override
    protected void check()  {

        COMPLETER_EASY_PVP=getStringList("message.completer.easyPvp",false);

        COMPLETER_EASY_PVP_KIT_CREATE=getStringList("message.completer.easyPvpKitCreate",false);
        COMPLETER_EASY_PVP_KIT_DELETE=getStringList("message.completer.easyPvpKitDelete",false);
        COMPLETER_EASY_PVP_KIT_DESCRIPTION_ADD=getStringList("message.completer.easyPvpKitDescriptionAdd",false);
        COMPLETER_EASY_PVP_KIT_DESCRIPTION_ADD_$=getStringList("message.completer.easyPvpKitDescriptionAdd$",false);
        COMPLETER_EASY_PVP_KIT_DESCRIPTION_REMOVE_$=getStringList("message.completer.easyPvpKitDescriptionRemove$",false);
        COMPLETER_EASY_PVP_KIT_DESCRIPTION_REMOVE=getStringList("message.completer.easyPvpKitDescriptionRemove",false);
        COMPLETER_EASY_PVP_KIT_DESCRIPTION_SET_$=getStringList("message.completer.easyPvpKitDescriptionSet$",false);

        COMPLETER_EASY_PVP_KIT_DESCRIPTION_SET_$_$=getStringList("message.completer.easyPvpKitDescriptionSet$$",false);
        COMPLETER_EASY_PVP_KIT_DESCRIPTION_SET=getStringList("message.completer.easyPvpKitDescriptionSet",false);
        COMPLETER_EASY_PVP_KIT_SET=getStringList("message.completer.easyPvpKitSet",false);
        COMPLETER_EASY_PVP_MAP_BUILD_SET=getStringList("message.completer.easyPvpMapBuildSet",false);
        COMPLETER_EASY_PVP_MAP_BUILD_SET_$=getStringList("message.completer.easyPvpMapBuildSet$",false);
        COMPLETER_EASY_PVP_MAP_CHOOSE_TICK_SET=getStringList("message.completer.easyPvpMapChooseTickSet",false);
        COMPLETER_EASY_PVP_MAP_CHOOSE_TICK_SET_$=getStringList("message.completer.easyPvpMapChooseTickSet$",false);
        COMPLETER_EASY_PVP_MAP_CREATE=getStringList("message.completer.easyPvpMapCreate",false);
        COMPLETER_EASY_PVP_MAP_DELETE=getStringList("message.completer.easyPvpMapDelete",false);
        COMPLETER_EASY_PVP_MAP_DESCRIPTION_ADD=getStringList("message.completer.easyPvpMapDescriptionAdd",false);
        COMPLETER_EASY_PVP_MAP_DESCRIPTION_ADD_$=getStringList("message.completer.easyPvpMapDescriptionAdd$",false);
        COMPLETER_EASY_PVP_MAP_DESCRIPTION_REMOVE=getStringList("message.completer.easyPvpMapDescriptionRemove",false);
        COMPLETER_EASY_PVP_MAP_DESCRIPTION_REMOVE_$=getStringList("message.completer.easyPvpMapDescriptionRemove$",false);
        COMPLETER_EASY_PVP_MAP_DESCRIPTION_SET=getStringList("message.completer.easyPvpMapDescriptionSet",false);
        COMPLETER_EASY_PVP_MAP_DESCRIPTION_SET_$=getStringList("message.completer.easyPvpMapDescriptionSet$",false);
        COMPLETER_EASY_PVP_MAP_DESCRIPTION_SET_$_$=getStringList("message.completer.easyPvpMapDescriptionSet$$",false);
        COMPLETER_EASY_PVP_MAP_DROP_SET=getStringList("message.completer.easyPvpMapDropSet",false);
        COMPLETER_EASY_PVP_MAP_DROP_SET_$=getStringList("message.completer.easyPvpMapDropSet$",false);
        COMPLETER_EASY_PVP_MAP_FAIR_SET=getStringList("message.completer.easyPvpMapFairSet",false);
        COMPLETER_EASY_PVP_MAP_FAIR_SET_$=getStringList("message.completer.easyPvpMapFairSet$",false);
        COMPLETER_EASY_PVP_MAP_SCALE_SET=getStringList("message.completer.easyPvpMapScaleSet",false);
        COMPLETER_EASY_PVP_MAP_SCALE_SET_$=getStringList("message.completer.easyPvpMapScaleSet$",false);
        COMPLETER_EASY_PVP_MAP_KIT_ADD=getStringList("message.completer.easyPvpMapKitAdd",false);
        COMPLETER_EASY_PVP_MAP_KIT_ADD_$=getStringList("message.completer.easyPvpMapKitAdd$",false);
        COMPLETER_EASY_PVP_MAP_KIT_REMOVE=getStringList("message.completer.easyPvpMapKitRemove",false);
        COMPLETER_EASY_PVP_MAP_KIT_REMOVE_$=getStringList("message.completer.easyPvpMapKitRemove$",false);
        COMPLETER_EASY_PVP_SECTION_SET=getStringList("message.completer.easyPvpSectionSet",false);




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




        CHAT_VERSION_NOTIFY=getStringList("message.chat.versionNotify",false);
        CHAT_NOT_PLAYER=getStringList("message.chat.notPlayer",false);

        CHAT_NO_PERMISSION=getStringList("message.chat.noPermission",false);
        CHAT_SUCCESS_KICK_MEMBER =getStringList("message.chat.successKickMember",false);


        CHAT_SUCCESS_GUI =getStringList("message.chat.successGui",false);
        CHAT_SUCCESS_HELP =getStringList("message.chat.successHelp",false);

        CHAT_SUCCESS_CORRECT_YAML=getStringList("message.chat.successCorrectYaml",false);
        CHAT_SUCCESS_RECORD_RESET=getStringList("message.chat.successRecordReset",false);

        CHAT_SUCCESS_RELOAD=getStringList("message.chat.successReload",false);


        CHAT_SUCCESS_RANK_PAGE=getStringList("message.chat.successRankPage",false);

        CHAT_SUCCESS_SECTION_SET=getStringList("message.chat.successSectionSet",false);

        CHAT_INVALID_ARGUMENT=getStringList("message.chat.invalidArgument",false);

        CHAT_FAILURE_MAP_CREATE_BECAUSE_INVALID_FOUR_POINT =getStringList
                ("message.chat.failureMapCreateBecauseInvalidFourPoint",false);

        CHAT_FAILURE_MAP_CREATE_BECAUSE_NOT_FOUR_POINT =getStringList
                ("message.chat.failureMapCreateBecauseNotFourPoint",false);

        CHAT_SUCCESS_MAP_CREATE=getStringList("message.chat.successMapCreate",false);
        CHAT_FAILURE_MAP_CREATE_BECAUSE_DUPLICATE_MAP_NAME=getStringList
                ("message.chat.failureMapCreateBecauseDuplicateMapName",false);

        CHAT_SUCCESS_MAP_DELETE=getStringList("message.chat.successMapDelete",false);
        CHAT_FAILURE_MAP_DELETE_BECAUSE_NOT_EXIST_MAP_NAME=getStringList
                ("message.chat.failureMapDeleteBecauseNotExistMapName",false);

        CHAT_SUCCESS_MAP_DESCRIPTION_ADD=getStringList("message.chat.successMapDescriptionAdd",false);
        CHAT_FAILURE_MAP_DESCRIPTION_ADD_BECAUSE_NOT_EXIST_MAP_NAME=getStringList
                ("message.chat.failureMapDescriptionAddBecauseNotExistMapName",false);

        CHAT_FAILURE_MAP_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_MAP_NAME=getStringList
                ("message.chat.failureMapDescriptionRemoveBecauseNotExistMapName",false);
        CHAT_FAILURE_MAP_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_DESCRIPTION_ROW=getStringList
                ("message.chat.failureMapDescriptionRemoveBecauseNotExistDescriptionRow",false);
        CHAT_SUCCESS_MAP_DESCRIPTION_REMOVE=getStringList("message.chat.successMapDescriptionRemove",false);

        CHAT_FAILURE_MAP_DESCRIPTION_SET_BECAUSE_NOT_EXIST_MAP_NAME=getStringList
                ("message.chat.failureMapDescriptionSetBecauseNotExistMapName",false);
        CHAT_FAILURE_MAP_DESCRIPTION_SET_BECAUSE_NOT_EXIST_DESCRIPTION_ROW=getStringList
                ("message.chat.failureMapDescriptionSetBecauseNotExistDescriptionRow",false);
        CHAT_SUCCESS_MAP_DESCRIPTION_SET=getStringList("message.chat.successMapDescriptionSet",false);

        CHAT_FAILURE_MAP_BUILD_SET_BECAUSE_NOT_EXIST_MAP_NAME=getStringList("message.chat.failureMapBuildSetBecauseNotExistMapName",false);
        CHAT_SUCCESS_MAP_BUILD_SET=getStringList("message.chat.successMapBuildSet",false);


        CHAT_FAILURE_MAP_CHOOSE_TICK_SET_BECAUSE_NOT_EXIST_MAP_NAME=getStringList("message.chat.failureMapChooseTickSetBecauseNotExistMapName",false);
        CHAT_SUCCESS_MAP_CHOOSE_TICK_SET=getStringList("message.chat.successMapChooseTickSet",false);


        CHAT_FAILURE_MAP_FAIR_SET_BECAUSE_NOT_EXIST_MAP_NAME=getStringList("message.chat.failureMapFairSetBecauseNotExistMapName",false);
        CHAT_SUCCESS_MAP_FAIR_SET=getStringList("message.chat.successMapFairSet",false);

        CHAT_FAILURE_MAP_SCALE_SET_BECAUSE_NOT_EXIST_MAP_NAME=getStringList("message.chat.failureMapScaleSetBecauseNotExistMapName",false);
        CHAT_SUCCESS_MAP_SCALE_SET=getStringList("message.chat.successMapScaleSet",false);

        CHAT_FAILURE_MAP_DROP_SET_BECAUSE_NOT_EXIST_MAP_NAME=getStringList("message.chat.failureMapDropSetBecauseNotExistMapName",false);
        CHAT_SUCCESS_MAP_DROP_SET=getStringList("message.chat.successMapDropSet",false);


        CHAT_SUCCESS_KIT_CREATE=getStringList("message.chat.successKitCreate",false);
        CHAT_FAILURE_KIT_CREATE_BECAUSE_DUPLICATE_KIT_NAME=getStringList
                ("message.chat.failureKitCreateBecauseDuplicateKitName",false);

        CHAT_SUCCESS_KIT_DELETE=getStringList("message.chat.successKitDelete",false);
        CHAT_FAILURE_KIT_DELETE_BECAUSE_NOT_EXIST_KIT_NAME=getStringList
                ("message.chat.failureKitDeleteBecauseNotExistKitName",false);

        CHAT_SUCCESS_KIT_SET=getStringList("message.chat.successKitSet",false);
        CHAT_FAILURE_KIT_SET_BECAUSE_NOT_EXIST_KIT_NAME=getStringList
                ("message.chat.failureKitSetBecauseNotExistKitName",false);

        CHAT_SUCCESS_MAP_KIT_ADD=getStringList("message.chat.successMapKitAdd",false);
        CHAT_FAILURE_MAP_KIT_ADD_BECAUSE_NOT_EXIST_KIT_NAME=getStringList
                ("message.chat.failureMapKitAddBecauseNotExistKitName",false);
        CHAT_FAILURE_MAP_KIT_ADD_BECAUSE_NOT_EXIST_MAP_NAME=getStringList
                ("message.chat.failureMapKitAddBecauseNotExistMapName",false);
        CHAT_FAILURE_MAP_KIT_ADD_BECAUSE_MAP_ALREADY_ADD_KIT=getStringList
                ("message.chat.failureMapKitAddBecauseMapAlreadyAddKit",false);

        CHAT_SUCCESS_MAP_KIT_REMOVE=getStringList("message.chat.successMapKitRemove",false);
        CHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_NOT_EXIST_KIT_NAME=getStringList
                ("message.chat.failureMapKitRemoveBecauseNotExistKitName",false);
        CHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_NOT_EXIST_MAP_NAME=getStringList
                ("message.chat.failureMapKitRemoveBecauseNotExistMapName",false);
        CHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_MAP_NOT_ADD_KIT=getStringList
                ("message.chat.failureMapKitRemoveBecauseMapNotAddKit",false);

        CHAT_SUCCESS_KIT_DESCRIPTION_ADD=getStringList("message.chat.successKitDescriptionAdd",false);
        CHAT_FAILURE_KIT_DESCRIPTION_ADD_BECAUSE_NOT_EXIST_KIT_NAME=getStringList
                ("message.chat.failureKitDescriptionAddBecauseNotExistKitName",false);

        CHAT_FAILURE_KIT_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_KIT_NAME=getStringList
                ("message.chat.failureKitDescriptionRemoveBecauseNotExistKitName",false);
        CHAT_FAILURE_KIT_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_DESCRIPTION_ROW=getStringList
                ("message.chat.failureKitDescriptionRemoveBecauseNotExistDescriptionRow",false);
        CHAT_SUCCESS_KIT_DESCRIPTION_REMOVE=getStringList("message.chat.successKitDescriptionRemove",false);

        CHAT_FAILURE_KIT_DESCRIPTION_SET_BECAUSE_NOT_EXIST_KIT_NAME=getStringList
                ("message.chat.failureKitDescriptionSetBecauseNotExistKitName",false);
        CHAT_FAILURE_KIT_DESCRIPTION_SET_BECAUSE_NOT_EXIST_DESCRIPTION_ROW=getStringList
                ("message.chat.failureKitDescriptionSetBecauseNotExistDescriptionRow",false);
        CHAT_SUCCESS_KIT_DESCRIPTION_SET=getStringList("message.chat.successKitDescriptionSet",false);

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
        CHAT_SOMEONE_SUCCESS_WAS_KICKED_PARTY=getStringList("message.chat.someoneSuccessWasKickedParty",false);
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



        CHAT_SUCCESS_RACE_START =getStringList("message.chat.successRaceStart",false);

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
        CHAT_FAILURE_WATCH_RACE_BECAUSE_IN_PARTY=getStringList("message.chat.failureWatchRaceBecauseInParty",false);

        CHAT_FAILURE_WATCH_RACE_BECAUSE_ALREADY_IN_WATCHING=getStringList("message.chat.failureWatchRaceBecauseAlreadyInWatching",false);
        CHAT_FAILURE_UNWATCH_RACE_BECAUSE_NOT_IN_WATCHING=getStringList("message.chat.failureUnwatchRaceBecauseNotInWatching",false);
        CHAT_SUCCESS_UNWATCH_RACE=getStringList("message.chat.successUnwatchRace",false);

        INPUT_CANCEL =getString("message.input.cancel",true);
       if (INPUT_CANCEL.contains(" ")||INPUT_CANCEL.equalsIgnoreCase("")){
           INPUT_CANCEL="cancel";
       }

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

    public List<String> getCHAT_FAILURE_WATCH_RACE_BECAUSE_IN_PARTY() {
        if (CHAT_FAILURE_WATCH_RACE_BECAUSE_IN_PARTY==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_WATCH_RACE_BECAUSE_IN_PARTY);
    }

    private List<String> CHAT_SUCCESS_SHOW_ALL_RACE_PAGE;
    private List<String> CHAT_SUCCESS_BACK_ALL_PARTY_PAGE_IN_ALL_RACE_PAGE;
    private List<String> CHAT_SUCCESS_WATCH_RACE;
    private List<String> CHAT_FAILURE_WATCH_RACE_BECAUSE_IN_PARTY;
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

    public List<String> getCHAT_SUCCESS_RANK_PAGE() {
        if (CHAT_SUCCESS_RANK_PAGE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_RANK_PAGE);
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

    public List<String> getCHAT_VERSION_NOTIFY() {
        if (CHAT_VERSION_NOTIFY==null){
            return null;
        }return new ArrayList<>(CHAT_VERSION_NOTIFY);
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

    public List<String> getCHAT_SUCCESS_GUI() {
        if (CHAT_SUCCESS_GUI==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_GUI);
    }

    public List<String> getCHAT_SUCCESS_RECORD_RESET() {
        if (CHAT_SUCCESS_RECORD_RESET==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_RECORD_RESET);
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
    public List<String> getCHAT_SUCCESS_MAP_CHOOSE_TICK_SET() {

        if (CHAT_SUCCESS_MAP_CHOOSE_TICK_SET==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_MAP_CHOOSE_TICK_SET);
    }

    public List<String> getCHAT_FAILURE_MAP_CHOOSE_TICK_SET_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_MAP_CHOOSE_TICK_SET_BECAUSE_NOT_EXIST_MAP_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_CHOOSE_TICK_SET_BECAUSE_NOT_EXIST_MAP_NAME);
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

    public List<String> getCHAT_SUCCESS_RACE_START() {
        if (CHAT_SUCCESS_RACE_START==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_RACE_START);
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

    public List<String> getCHAT_SUCCESS_MAP_DESCRIPTION_ADD() {
        if (CHAT_SUCCESS_MAP_DESCRIPTION_ADD==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_MAP_DESCRIPTION_ADD);
    }

    public List<String> getCHAT_FAILURE_MAP_DESCRIPTION_ADD_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_MAP_DESCRIPTION_ADD_BECAUSE_NOT_EXIST_MAP_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_DESCRIPTION_ADD_BECAUSE_NOT_EXIST_MAP_NAME);
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

    public List<String> getCHAT_SUCCESS_KIT_DESCRIPTION_ADD() {
        if (CHAT_SUCCESS_KIT_DESCRIPTION_ADD==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_KIT_DESCRIPTION_ADD);
    }

    public List<String> getCHAT_FAILURE_KIT_DESCRIPTION_ADD_BECAUSE_NOT_EXIST_KIT_NAME() {
        if (CHAT_FAILURE_KIT_DESCRIPTION_ADD_BECAUSE_NOT_EXIST_KIT_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_KIT_DESCRIPTION_ADD_BECAUSE_NOT_EXIST_KIT_NAME);
    }

    public List<String> getCHAT_FAILURE_KIT_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_KIT_NAME() {
        if (CHAT_FAILURE_KIT_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_KIT_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_KIT_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_KIT_NAME);
    }

    public List<String> getCHAT_FAILURE_KIT_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_DESCRIPTION_ROW() {
        if (CHAT_FAILURE_KIT_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_DESCRIPTION_ROW==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_KIT_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_DESCRIPTION_ROW);
    }

    public List<String> getCHAT_SUCCESS_KIT_DESCRIPTION_REMOVE() {
        if (CHAT_SUCCESS_KIT_DESCRIPTION_REMOVE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_KIT_DESCRIPTION_REMOVE);
    }

    public List<String> getCHAT_FAILURE_KIT_DESCRIPTION_SET_BECAUSE_NOT_EXIST_KIT_NAME() {
        if (CHAT_FAILURE_KIT_DESCRIPTION_SET_BECAUSE_NOT_EXIST_KIT_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_KIT_DESCRIPTION_SET_BECAUSE_NOT_EXIST_KIT_NAME);
    }

    public List<String> getCHAT_FAILURE_KIT_DESCRIPTION_SET_BECAUSE_NOT_EXIST_DESCRIPTION_ROW() {
        if (CHAT_FAILURE_KIT_DESCRIPTION_SET_BECAUSE_NOT_EXIST_DESCRIPTION_ROW==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_KIT_DESCRIPTION_SET_BECAUSE_NOT_EXIST_DESCRIPTION_ROW);
    }

    public List<String> getCHAT_SUCCESS_KIT_DESCRIPTION_SET() {
        if (CHAT_SUCCESS_KIT_DESCRIPTION_SET==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_KIT_DESCRIPTION_SET);
    }

    public List<String> getCHAT_SUCCESS_MAP_KIT_REMOVE() {
        if (CHAT_SUCCESS_MAP_KIT_REMOVE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_MAP_KIT_REMOVE);
    }

    public List<String> getCHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_NOT_EXIST_KIT_NAME() {
        if (CHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_NOT_EXIST_KIT_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_NOT_EXIST_KIT_NAME);
    }

    public List<String> getCHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_NOT_EXIST_MAP_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_MAP_NOT_ADD_KIT() {
        if (CHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_MAP_NOT_ADD_KIT==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_MAP_NOT_ADD_KIT);
    }

    public List<String> getCHAT_SUCCESS_MAP_KIT_ADD() {
        if (CHAT_SUCCESS_MAP_KIT_ADD==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_MAP_KIT_ADD);
    }

    public List<String> getCHAT_FAILURE_MAP_KIT_ADD_BECAUSE_NOT_EXIST_KIT_NAME() {
        if (CHAT_FAILURE_MAP_KIT_ADD_BECAUSE_NOT_EXIST_KIT_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_KIT_ADD_BECAUSE_NOT_EXIST_KIT_NAME);
    }

    public List<String> getCHAT_FAILURE_MAP_KIT_ADD_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_MAP_KIT_ADD_BECAUSE_NOT_EXIST_MAP_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_KIT_ADD_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_MAP_KIT_ADD_BECAUSE_MAP_ALREADY_ADD_KIT() {
        if (CHAT_FAILURE_MAP_KIT_ADD_BECAUSE_MAP_ALREADY_ADD_KIT==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_KIT_ADD_BECAUSE_MAP_ALREADY_ADD_KIT);
    }

    public List<String> getCHAT_SUCCESS_KIT_SET() {
        if (CHAT_SUCCESS_KIT_SET==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_KIT_SET);
    }

    public List<String> getCHAT_FAILURE_KIT_SET_BECAUSE_NOT_EXIST_KIT_NAME() {
        if (CHAT_FAILURE_KIT_SET_BECAUSE_NOT_EXIST_KIT_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_KIT_SET_BECAUSE_NOT_EXIST_KIT_NAME);
    }

    public List<String> getCHAT_SUCCESS_KIT_DELETE() {
        if (CHAT_SUCCESS_KIT_DELETE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_KIT_DELETE);
    }

    public List<String> getCHAT_FAILURE_KIT_DELETE_BECAUSE_NOT_EXIST_KIT_NAME() {
        if (CHAT_FAILURE_KIT_DELETE_BECAUSE_NOT_EXIST_KIT_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_KIT_DELETE_BECAUSE_NOT_EXIST_KIT_NAME);
    }

    public List<String> getCHAT_SUCCESS_KIT_CREATE() {
        if (CHAT_SUCCESS_KIT_CREATE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_KIT_CREATE);
    }

    public List<String> getCHAT_FAILURE_KIT_CREATE_BECAUSE_DUPLICATE_KIT_NAME() {
        if (CHAT_FAILURE_KIT_CREATE_BECAUSE_DUPLICATE_KIT_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_KIT_CREATE_BECAUSE_DUPLICATE_KIT_NAME);
    }

    public List<String> getCHAT_SUCCESS_MAP_BUILD_SET() {
        if (CHAT_SUCCESS_MAP_BUILD_SET==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_MAP_BUILD_SET);
    }

    public List<String> getCHAT_SUCCESS_MAP_FAIR_SET() {
        if (CHAT_SUCCESS_MAP_FAIR_SET==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_MAP_FAIR_SET);
    }

    public List<String> getCHAT_SUCCESS_MAP_SCALE_SET() {
        if (CHAT_SUCCESS_MAP_SCALE_SET==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_MAP_SCALE_SET);
    }

    public List<String> getCHAT_SUCCESS_MAP_DROP_SET() {
        if (CHAT_SUCCESS_MAP_DROP_SET==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_MAP_DROP_SET);
    }

    public List<String> getCHAT_FAILURE_MAP_FAIR_SET_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_MAP_FAIR_SET_BECAUSE_NOT_EXIST_MAP_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_FAIR_SET_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_MAP_BUILD_SET_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_MAP_BUILD_SET_BECAUSE_NOT_EXIST_MAP_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_BUILD_SET_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_MAP_DROP_SET_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_MAP_DROP_SET_BECAUSE_NOT_EXIST_MAP_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_DROP_SET_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_MAP_SCALE_SET_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_MAP_SCALE_SET_BECAUSE_NOT_EXIST_MAP_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_SCALE_SET_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_MAP_DESCRIPTION_SET_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_MAP_DESCRIPTION_SET_BECAUSE_NOT_EXIST_MAP_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_DESCRIPTION_SET_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_MAP_DESCRIPTION_SET_BECAUSE_NOT_EXIST_DESCRIPTION_ROW() {
        if (CHAT_FAILURE_MAP_DESCRIPTION_SET_BECAUSE_NOT_EXIST_DESCRIPTION_ROW==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_DESCRIPTION_SET_BECAUSE_NOT_EXIST_DESCRIPTION_ROW);
    }

    public List<String> getCHAT_SUCCESS_MAP_DESCRIPTION_SET() {
        if (CHAT_SUCCESS_MAP_DESCRIPTION_SET==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_MAP_DESCRIPTION_SET);
    }

    public List<String> getCHAT_FAILURE_MAP_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_MAP_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_MAP_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_FAILURE_MAP_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_DESCRIPTION_ROW() {
        if (CHAT_FAILURE_MAP_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_DESCRIPTION_ROW==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_DESCRIPTION_ROW);
    }

    public List<String> getCHAT_SUCCESS_MAP_DESCRIPTION_REMOVE() {
        if (CHAT_SUCCESS_MAP_DESCRIPTION_REMOVE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_MAP_DESCRIPTION_REMOVE);
    }

    public List<String> getCHAT_SUCCESS_SECTION_SET() {
        if (CHAT_SUCCESS_SECTION_SET==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_SECTION_SET);
    }

    public List<String> getCHAT_INVALID_ARGUMENT() {
        if (CHAT_INVALID_ARGUMENT==null){
            return null;
        }return new ArrayList<>(CHAT_INVALID_ARGUMENT);
    }
    public List<String> getCHAT_FAILURE_MAP_DELETE_BECAUSE_NOT_EXIST_MAP_NAME() {
        if (CHAT_FAILURE_MAP_DELETE_BECAUSE_NOT_EXIST_MAP_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_DELETE_BECAUSE_NOT_EXIST_MAP_NAME);
    }

    public List<String> getCHAT_SUCCESS_MAP_DELETE() {
        if (CHAT_SUCCESS_MAP_DELETE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_MAP_DELETE);
    }

    public List<String> getCHAT_FAILURE_MAP_CREATE_BECAUSE_DUPLICATE_MAP_NAME() {
        if (CHAT_FAILURE_MAP_CREATE_BECAUSE_DUPLICATE_MAP_NAME==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MAP_CREATE_BECAUSE_DUPLICATE_MAP_NAME);
    }

    public List<String> getCHAT_SUCCESS_MAP_CREATE() {
        if (CHAT_SUCCESS_MAP_CREATE==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_MAP_CREATE);
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

    public List<String> getCHAT_SUCCESS_RELOAD() {
        if (CHAT_SUCCESS_RELOAD==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_RELOAD);
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
