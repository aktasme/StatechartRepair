
############# Target type (Debug/Release) ##################
############################################################
CPPCompileDebug= /Zi /Od /D "_DEBUG" $(LIBCRT_FLAG)d  /Fd"$(TARGET_NAME)" 
CPPCompileRelease= /Ox /D"NDEBUG" $(LIBCRT_FLAG) /Fd"$(TARGET_NAME)" 
LinkDebug=
LinkRelease=
BuildSet=Debug
SUBSYSTEM=/SUBSYSTEM:console
RPFrameWorkDll=False
SimulinkLibName=

ConfigurationCPPCompileSwitches=   /I . /I . /I $(OMROOT)\LangCpp /I $(OMROOT)\LangCpp\oxf /nologo /W3 $(ENABLE_EH) $(CRT_FLAGS) $(CPPCompileDebug) /D "_AFXDLL" /D "WIN32" /D "_CONSOLE" /D "_MBCS" /D "_WINDOWS" $(INST_FLAGS) $(INCLUDE_PATH) $(INST_INCLUDES) /c   

SIMULINK_CONFIG=False
!IF "$(SIMULINK_CONFIG)" == "True"
ConfigurationCPPCompileSwitches=$(ConfigurationCPPCompileSwitches) /D "OM_WITH_CLEANUP"
!ENDIF


!IF "$(RPFrameWorkDll)" == "True"
ConfigurationCPPCompileSwitches=$(ConfigurationCPPCompileSwitches) /D "FRAMEWORK_DLL"
!ENDIF

################### Compilation flags ######################
############################################################
INCLUDE_QUALIFIER=/I
DEFINE_QUALIFIER=/D

!IF "False" == "True"
MT_PREFIX=MT
LIBCRT_FLAG=/MT
!ELSE
MT_PREFIX=
LIBCRT_FLAG=/MD
!ENDIF

LIB_PREFIX=MSVC10x86$(MT_PREFIX)

CRT_FLAGS=$(DEFINE_QUALIFIER)_CRT_SECURE_NO_DEPRECATE $(DEFINE_QUALIFIER)_CRT_SECURE_NO_WARNINGS
ENABLE_EH=/EHa

WINMM_LIB=winmm.lib

################### Commands definition #########################
#################################################################
RMDIR = rmdir
LIB_CMD=link.exe -lib
LINK_CMD=link.exe
LIB_FLAGS=$(LinkDebug)  /NOLOGO   
LINK_FLAGS=$(LinkDebug)  /NOLOGO    $(SUBSYSTEM) /MACHINE:x86 

############### Generated macros #################
##################################################

FLAGSFILE=
RULESFILE=
OMROOT="C:\Rhapsody\8.4\Share"
RHPROOT="C:\Rhapsody\8.4"

CPP_EXT=.cpp
H_EXT=.h
OBJ_EXT=.obj
EXE_EXT=.exe
LIB_EXT=.lib

INSTRUMENTATION=None

TIME_MODEL=RealTime

TARGET_TYPE=Executable

TARGET_NAME=DefaultComponent

all : $(TARGET_NAME)$(EXE_EXT) DefaultComponent.mak

TARGET_MAIN=MainDefaultComponent

LIBS=

INCLUDE_PATH= \
  $(INCLUDE_QUALIFIER)$(OMROOT)/LangCpp/osconfig/WIN32

ADDITIONAL_OBJS=

OBJS= \
  CSD_1.obj \
  CSD_2.obj \
  CSD_3.obj \
  CSD_4.obj \
  CSD_5.obj \
  TBSWDH_1.obj \
  TBSWDH_2.obj \
  TBSWDH_3.obj \
  TBSWDH_4.obj \
  TBSWDH_5.obj \
  TWCWOE_1.obj \
  TWCWOE_2.obj \
  TWCWOE_3.obj \
  TWCWOE_4.obj \
  TWCWOE_5.obj \
  ISN_1.obj \
  ISN_2.obj \
  ISN_3.obj \
  ISN_4.obj \
  ISN_5.obj \
  IS_1.obj \
  IS_2.obj \
  IS_3.obj \
  IS_4.obj \
  IS_5.obj \
  URS_1.obj \
  URS_2.obj \
  URS_3.obj \
  URS_4.obj \
  URS_5.obj \
  NC_1.obj \
  UNS_1.obj \
  Default.obj




OBJ_DIR=

!IF "$(OBJ_DIR)"!=""
CREATE_OBJ_DIR=if not exist $(OBJ_DIR) mkdir $(OBJ_DIR)
CLEAN_OBJ_DIR= if exist $(OBJ_DIR) $(RMDIR) $(OBJ_DIR)
!ELSE
CREATE_OBJ_DIR=
CLEAN_OBJ_DIR=
!ENDIF

######################## Predefined macros ############################
#######################################################################
!IF "$(OBJS)" != ""
$(OBJS) : $(INST_LIBS) $(OXF_LIBS)
!ENDIF

LIB_POSTFIX=
!IF "$(BuildSet)"=="Release"
LIB_POSTFIX=R
!ENDIF

!IF "$(TARGET_TYPE)" == "Executable"
LinkDebug=$(LinkDebug) /DEBUG
LinkRelease=$(LinkRelease) /OPT:NOREF
!ELSEIF "$(TARGET_TYPE)" == "Library"
LinkDebug=$(LinkDebug)
!ENDIF


!IF "$(INSTRUMENTATION)" == "Animation"
INST_FLAGS=/D "OMANIMATOR"
INST_INCLUDES=/I $(OMROOT)\LangCpp\aom /I $(OMROOT)\LangCpp\tom
!IF "$(RPFrameWorkDll)" == "True"
INST_LIBS= 
OXF_LIBS=$(OMROOT)\LangCpp\lib\$(LIB_PREFIX)oxfanimdll$(LIB_POSTFIX)$(LIB_EXT) 
!ELSE
INST_LIBS= $(OMROOT)\LangCpp\lib\$(LIB_PREFIX)aomanim$(LIB_POSTFIX)$(LIB_EXT) $(OMROOT)\LangCpp\lib\$(LIB_PREFIX)oxsiminst$(LIB_POSTFIX)$(LIB_EXT)
OXF_LIBS=$(OMROOT)\LangCpp\lib\$(LIB_PREFIX)oxfinst$(LIB_POSTFIX)$(LIB_EXT) $(OMROOT)\LangCpp\lib\$(LIB_PREFIX)omComAppl$(LIB_POSTFIX)$(LIB_EXT) $(SimulinkLibName)
!ENDIF
SOCK_LIB=wsock32.lib

!ELSEIF "$(INSTRUMENTATION)" == "Tracing"
INST_FLAGS=/D "OMTRACER"
INST_INCLUDES=/I $(OMROOT)\LangCpp\aom /I $(OMROOT)\LangCpp\tom
!IF "$(RPFrameWorkDll)" == "True"
INST_LIBS=
OXF_LIBS= $(OMROOT)\LangCpp\lib\$(LIB_PREFIX)oxftracedll$(LIB_POSTFIX)$(LIB_EXT) 
!ELSE
INST_LIBS=$(OMROOT)\LangCpp\lib\$(LIB_PREFIX)tomtrace$(LIB_POSTFIX)$(LIB_EXT) $(OMROOT)\LangCpp\lib\$(LIB_PREFIX)aomtrace$(LIB_POSTFIX)$(LIB_EXT) $(OMROOT)\LangCpp\lib\$(LIB_PREFIX)oxsiminst$(LIB_POSTFIX)$(LIB_EXT)
OXF_LIBS= $(OMROOT)\LangCpp\lib\$(LIB_PREFIX)oxfinst$(LIB_POSTFIX)$(LIB_EXT) $(OMROOT)\LangCpp\lib\$(LIB_PREFIX)omComAppl$(LIB_POSTFIX)$(LIB_EXT) $(SimulinkLibName)
!ENDIF
SOCK_LIB=wsock32.lib

!ELSEIF "$(INSTRUMENTATION)" == "None" 
INST_FLAGS=
INST_INCLUDES=
INST_LIBS=
!IF "$(RPFrameWorkDll)" == "True"
OXF_LIBS=$(OMROOT)\LangCpp\lib\$(LIB_PREFIX)oxfdll$(LIB_POSTFIX)$(LIB_EXT) $(OMROOT)\LangCpp\lib\$(LIB_PREFIX)oxsim$(LIB_POSTFIX)$(LIB_EXT)
!ELSE
OXF_LIBS=$(OMROOT)\LangCpp\lib\$(LIB_PREFIX)oxf$(LIB_POSTFIX)$(LIB_EXT) $(SimulinkLibName) $(OMROOT)\LangCpp\lib\$(LIB_PREFIX)oxsim$(LIB_POSTFIX)$(LIB_EXT)
!ENDIF
SOCK_LIB=

!ELSE
!ERROR An invalid Instrumentation $(INSTRUMENTATION) is specified.
!ENDIF



################## Generated dependencies ########################
##################################################################






CSD_1.obj : CSD_1.cpp CSD_1.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"CSD_1.obj" "CSD_1.cpp" 



CSD_2.obj : CSD_2.cpp CSD_2.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"CSD_2.obj" "CSD_2.cpp" 



CSD_3.obj : CSD_3.cpp CSD_3.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"CSD_3.obj" "CSD_3.cpp" 



CSD_4.obj : CSD_4.cpp CSD_4.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"CSD_4.obj" "CSD_4.cpp" 



CSD_5.obj : CSD_5.cpp CSD_5.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"CSD_5.obj" "CSD_5.cpp" 



TBSWDH_1.obj : TBSWDH_1.cpp TBSWDH_1.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"TBSWDH_1.obj" "TBSWDH_1.cpp" 



TBSWDH_2.obj : TBSWDH_2.cpp TBSWDH_2.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"TBSWDH_2.obj" "TBSWDH_2.cpp" 



TBSWDH_3.obj : TBSWDH_3.cpp TBSWDH_3.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"TBSWDH_3.obj" "TBSWDH_3.cpp" 



TBSWDH_4.obj : TBSWDH_4.cpp TBSWDH_4.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"TBSWDH_4.obj" "TBSWDH_4.cpp" 



TBSWDH_5.obj : TBSWDH_5.cpp TBSWDH_5.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"TBSWDH_5.obj" "TBSWDH_5.cpp" 



TWCWOE_1.obj : TWCWOE_1.cpp TWCWOE_1.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"TWCWOE_1.obj" "TWCWOE_1.cpp" 



TWCWOE_2.obj : TWCWOE_2.cpp TWCWOE_2.h    
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"TWCWOE_2.obj" "TWCWOE_2.cpp" 



TWCWOE_3.obj : TWCWOE_3.cpp TWCWOE_3.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"TWCWOE_3.obj" "TWCWOE_3.cpp" 



TWCWOE_4.obj : TWCWOE_4.cpp TWCWOE_4.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"TWCWOE_4.obj" "TWCWOE_4.cpp" 



TWCWOE_5.obj : TWCWOE_5.cpp TWCWOE_5.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"TWCWOE_5.obj" "TWCWOE_5.cpp" 



ISN_1.obj : ISN_1.cpp ISN_1.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"ISN_1.obj" "ISN_1.cpp" 



ISN_2.obj : ISN_2.cpp ISN_2.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"ISN_2.obj" "ISN_2.cpp" 



ISN_3.obj : ISN_3.cpp ISN_3.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"ISN_3.obj" "ISN_3.cpp" 



ISN_4.obj : ISN_4.cpp ISN_4.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"ISN_4.obj" "ISN_4.cpp" 



ISN_5.obj : ISN_5.cpp ISN_5.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"ISN_5.obj" "ISN_5.cpp" 



IS_1.obj : IS_1.cpp IS_1.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"IS_1.obj" "IS_1.cpp" 



IS_2.obj : IS_2.cpp IS_2.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"IS_2.obj" "IS_2.cpp" 



IS_3.obj : IS_3.cpp IS_3.h    
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"IS_3.obj" "IS_3.cpp" 



IS_4.obj : IS_4.cpp IS_4.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"IS_4.obj" "IS_4.cpp" 



IS_5.obj : IS_5.cpp IS_5.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"IS_5.obj" "IS_5.cpp" 



URS_1.obj : URS_1.cpp URS_1.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"URS_1.obj" "URS_1.cpp" 



URS_2.obj : URS_2.cpp URS_2.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"URS_2.obj" "URS_2.cpp" 



URS_3.obj : URS_3.cpp URS_3.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"URS_3.obj" "URS_3.cpp" 



URS_4.obj : URS_4.cpp URS_4.h    
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"URS_4.obj" "URS_4.cpp" 



URS_5.obj : URS_5.cpp URS_5.h    
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"URS_5.obj" "URS_5.cpp" 



NC_1.obj : NC_1.cpp NC_1.h    
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"NC_1.obj" "NC_1.cpp" 



UNS_1.obj : UNS_1.cpp UNS_1.h    Default.h 
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"UNS_1.obj" "UNS_1.cpp" 



Default.obj : Default.cpp Default.h    
	$(CREATE_OBJ_DIR)
	$(CPP) $(ConfigurationCPPCompileSwitches)  /Fo"Default.obj" "Default.cpp" 






$(TARGET_MAIN)$(OBJ_EXT) : $(TARGET_MAIN)$(CPP_EXT) $(OBJS) 
	$(CPP) $(ConfigurationCPPCompileSwitches) /Fo"$(TARGET_MAIN)$(OBJ_EXT)" $(TARGET_MAIN)$(CPP_EXT)

########################## Linking instructions ###############################
###############################################################################
$(TARGET_NAME)$(EXE_EXT): $(OBJS) $(ADDITIONAL_OBJS) $(TARGET_MAIN)$(OBJ_EXT) DefaultComponent.mak 
	@echo Linking $(TARGET_NAME)$(EXE_EXT)
	$(LINK_CMD)  $(TARGET_MAIN)$(OBJ_EXT) $(OBJS) $(ADDITIONAL_OBJS) \
	$(LIBS) \
	$(INST_LIBS) \
	$(OXF_LIBS) \
	$(SOCK_LIB) \
	$(WINMM_LIB) \
	$(LINK_FLAGS) /out:$(TARGET_NAME)$(EXE_EXT)
	if exist $(TARGET_NAME)$(EXE_EXT).manifest mt.exe -manifest $@.manifest -outputresource:$(TARGET_NAME)$(EXE_EXT);1



$(TARGET_NAME)$(LIB_EXT) : $(OBJS) $(ADDITIONAL_OBJS) DefaultComponent.mak
	@echo Building library $@
	$(LIB_CMD) $(LIB_FLAGS) /out:$(TARGET_NAME)$(LIB_EXT) $(OBJS) $(ADDITIONAL_OBJS) $(LIBS)

clean:
	@echo Cleanup
	if exist CSD_1.obj erase CSD_1.obj
	if exist CSD_2.obj erase CSD_2.obj
	if exist CSD_3.obj erase CSD_3.obj
	if exist CSD_4.obj erase CSD_4.obj
	if exist CSD_5.obj erase CSD_5.obj
	if exist TBSWDH_1.obj erase TBSWDH_1.obj
	if exist TBSWDH_2.obj erase TBSWDH_2.obj
	if exist TBSWDH_3.obj erase TBSWDH_3.obj
	if exist TBSWDH_4.obj erase TBSWDH_4.obj
	if exist TBSWDH_5.obj erase TBSWDH_5.obj
	if exist TWCWOE_1.obj erase TWCWOE_1.obj
	if exist TWCWOE_2.obj erase TWCWOE_2.obj
	if exist TWCWOE_3.obj erase TWCWOE_3.obj
	if exist TWCWOE_4.obj erase TWCWOE_4.obj
	if exist TWCWOE_5.obj erase TWCWOE_5.obj
	if exist ISN_1.obj erase ISN_1.obj
	if exist ISN_2.obj erase ISN_2.obj
	if exist ISN_3.obj erase ISN_3.obj
	if exist ISN_4.obj erase ISN_4.obj
	if exist ISN_5.obj erase ISN_5.obj
	if exist IS_1.obj erase IS_1.obj
	if exist IS_2.obj erase IS_2.obj
	if exist IS_3.obj erase IS_3.obj
	if exist IS_4.obj erase IS_4.obj
	if exist IS_5.obj erase IS_5.obj
	if exist URS_1.obj erase URS_1.obj
	if exist URS_2.obj erase URS_2.obj
	if exist URS_3.obj erase URS_3.obj
	if exist URS_4.obj erase URS_4.obj
	if exist URS_5.obj erase URS_5.obj
	if exist NC_1.obj erase NC_1.obj
	if exist UNS_1.obj erase UNS_1.obj
	if exist Default.obj erase Default.obj
	if exist $(TARGET_MAIN)$(OBJ_EXT) erase $(TARGET_MAIN)$(OBJ_EXT)
	if exist *$(OBJ_EXT) erase *$(OBJ_EXT)
	if exist $(TARGET_NAME).pdb erase $(TARGET_NAME).pdb
	if exist $(TARGET_NAME)$(LIB_EXT) erase $(TARGET_NAME)$(LIB_EXT)
	if exist $(TARGET_NAME).ilk erase $(TARGET_NAME).ilk
	if exist $(TARGET_NAME)$(EXE_EXT) erase $(TARGET_NAME)$(EXE_EXT)
	if exist $(TARGET_NAME)$(EXE_EXT).manifest erase $(TARGET_NAME)$(EXE_EXT).manifest
	$(CLEAN_OBJ_DIR)
	
