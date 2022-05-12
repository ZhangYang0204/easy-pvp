package pers.zhangyang.easypvp.manager;

import pers.zhangyang.easypvp.base.YamlManagerBase;

import java.util.ArrayList;
import java.util.List;

public class MessageYamlManager extends YamlManagerBase {
    public static final MessageYamlManager MESSAGE_YAML_MANAGER =new MessageYamlManager();

    private MessageYamlManager( ) {
        super("language/"+SettingYamlManager.SETTING_YAML_MANAGER.getLANGUAGE()+"/message.yml");
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

    private List<String> CHAT_SUCCESS_MY_PARTY;
    private List<String> CHAT_SUCCESS_MAP_KIT_REMOVE;

    private List<String> CHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_NOT_EXIST_MAP_NAME;

    private List<String> CHAT_FAILURE_MAP_KIT_REMOVE_BECAUSE_MAP_NOT_ADD_KIT;

    private List<String> CHAT_SUCCESS_KIT_DESCRIPTION_ADD;

    private List<String> CHAT_FAILURE_KIT_DESCRIPTION_ADD_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_FAILURE_KIT_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_FAILURE_KIT_DESCRIPTION_REMOVE_BECAUSE_NOT_EXIST_DESCRIPTION_ROW;

    private List<String> CHAT_SUCCESS_KIT_DESCRIPTION_REMOVE;

    private List<String> CHAT_FAILURE_KIT_DESCRIPTION_SET_BECAUSE_NOT_EXIST_KIT_NAME;

    private List<String> CHAT_FAILURE_KIT_DESCRIPTION_SET_BECAUSE_NOT_EXIST_DESCRIPTION_ROW;

    private List<String> CHAT_SUCCESS_KIT_DESCRIPTION_SET;
    private List<String> CHAT_FAILURE_CREATE_PARTY_BECAUSE_ALREADY_JOIN_PARTY;

    private List<String> CHAT_SUCCESS_CREATE_PARTY;

    private List<String> CHAT_FAILURE_JOIN_PARTY_BECAUSE_ALREADY_JOIN_PARTY;

    private List<String> CHAT_FAILURE_KICK_MEMBER_BECAUSE_NOT_CAPTAIN;

    private List<String> CHAT_SUCCESS_JOIN_PARTY;
    private List<String> CHAT_SOMEONE_SUCCESS_JOIN_PARTY;
    private List<String> CHAT_SOMEONE_SUCCESS_LEAVE_PARTY;
    private List<String> CHAT_SOMEONE_SUCCESS_WAS_KICKED_PARTY;

    private List<String> CHAT_SUCCESS_WAS_KICKED_PARTY;

    private List<String> CHAT_FAILURE_MY_PARTY_BECAUSE_NOT_JOIN_PARTY;
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

    private List<String> CHAT_SUCCESS_CHOOSE_KIT;
    private List<String> CHAT_SUCCESS_STOP_CHOOSE_KIT;
    private List<String> CHAT_SUCCESS_BACK_ALL_MEMBER_PAGE;
    private List<String> CHAT_SUCCESS_CHOOSE_MAP;
    @Override
    protected void check()  {
        CHAT_VERSION_NOTIFY=getStringList("message.chat.versionNotify",false);
        CHAT_NOT_PLAYER=getStringList("message.chat.notPlayer",false);

        CHAT_NO_PERMISSION=getStringList("message.chat.noPermission",false);
        CHAT_SUCCESS_KICK_MEMBER =getStringList("message.chat.successKickMember",false);


        CHAT_SUCCESS_GUI =getStringList("message.chat.successGui",false);
        CHAT_SUCCESS_HELP =getStringList("message.chat.successHelp",false);

        CHAT_SUCCESS_CORRECT_YAML=getStringList("message.chat.successCorrectYaml",false);
        CHAT_SUCCESS_RECORD_RESET=getStringList("message.chat.successRecordReset",false);

        CHAT_SUCCESS_RELOAD=getStringList("message.chat.successReload",false);

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

        CHAT_FAILURE_MY_PARTY_BECAUSE_NOT_JOIN_PARTY =getStringList
                ("message.chat.failureMyPartyBecauseNotJoinParty",false);

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

        CHAT_SUCCESS_RACE_START =getStringList("message.chat.successRaceStart",false);

        CHAT_SOMEONE_SUCCESS_RACE_STOP_DRAW =getStringList("message.chat.someoneSuccessRaceStopDraw",false);
        CHAT_SOMEONE_SUCCESS_RACE_STOP_NOT_DRAW =getStringList("message.chat.someoneSuccessRaceStopNotDraw",false);
        CHAT_SUCCESS_MY_PARTY =getStringList("message.chat.successMyParty",false);
        CHAT_SUCCESS_BACK_ALL_PARTY_PAGE =getStringList("message.chat.successBackAllPartyPage",false);
        CHAT_SUCCESS_LEAVE_PARTY =getStringList("message.chat.successLeaveParty",false);

        CHAT_SUCCESS_CHOOSE_MAP =getStringList("message.chat.successChooseMap",false);
        CHAT_SUCCESS_BACK_ALL_MEMBER_PAGE =getStringList("message.chat.successBackAllMemberPage",false);

        CHAT_SUCCESS_CHOOSE_KIT =getStringList("message.chat.successChooseKit",false);
        CHAT_SUCCESS_STOP_CHOOSE_KIT =getStringList("message.chat.successStopChooseKit",false);

        INPUT_CANCEL =getString("message.input.cancel",true);
       if (INPUT_CANCEL.contains(" ")||INPUT_CANCEL.equalsIgnoreCase("")){
           INPUT_CANCEL="cancel";
       }

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

    public List<String> getCHAT_SUCCESS_CHOOSE_MAP() {
        if (CHAT_SUCCESS_CHOOSE_MAP==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_CHOOSE_MAP);
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

    public List<String> getCHAT_SUCCESS_MY_PARTY() {
        if (CHAT_SUCCESS_MY_PARTY==null){
            return null;
        }return new ArrayList<>(CHAT_SUCCESS_MY_PARTY);
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

    public List<String> getCHAT_FAILURE_MY_PARTY_BECAUSE_NOT_JOIN_PARTY() {
        if (CHAT_FAILURE_MY_PARTY_BECAUSE_NOT_JOIN_PARTY==null){
            return null;
        }return new ArrayList<>(CHAT_FAILURE_MY_PARTY_BECAUSE_NOT_JOIN_PARTY);
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
