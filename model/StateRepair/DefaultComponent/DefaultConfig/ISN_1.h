/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: ISN_1
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\ISN_1.h
*********************************************************************/

#ifndef ISN_1_H
#define ISN_1_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _4_InvalidStateName

//## class ISN_1
class ISN_1 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    ISN_1(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~ISN_1();
    
    ////    Additional operations    ////
    
    //## auto_generated
    virtual bool startBehavior();

protected :

    //## auto_generated
    void initStatechart();
    
    ////    Framework operations    ////

public :

    // rootState:
    //## statechart_method
    inline bool rootState_IN() const;
    
    //## statechart_method
    virtual void rootState_entDef();
    
    //## statechart_method
    virtual IOxfReactive::TakeEventStatus rootState_processEvent();
    
    // FOVAdjusment:
    //## statechart_method
    inline bool FOVAdjusment_IN() const;
    
    //## statechart_method
    void FOVAdjusment_entDef();
    
    // state_660:
    //## statechart_method
    inline bool state_660_IN() const;
    
    // state_659:
    //## statechart_method
    inline bool state_659_IN() const;
    
    // InitialFOV:
    //## statechart_method
    inline bool InitialFOV_IN() const;
    
    ////    Framework    ////

protected :

//#[ ignore
    enum ISN_1_Enum {
        OMNonState = 0,
        FOVAdjusment = 1,
        state_660 = 2,
        state_659 = 3,
        InitialFOV = 4
    };
    
    int rootState_subState;
    
    int rootState_active;
    
    int FOVAdjusment_subState;
//#]
};

inline bool ISN_1::rootState_IN() const {
    return true;
}

inline bool ISN_1::FOVAdjusment_IN() const {
    return rootState_subState == FOVAdjusment;
}

inline bool ISN_1::state_660_IN() const {
    return FOVAdjusment_subState == state_660;
}

inline bool ISN_1::state_659_IN() const {
    return FOVAdjusment_subState == state_659;
}

inline bool ISN_1::InitialFOV_IN() const {
    return FOVAdjusment_subState == InitialFOV;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\ISN_1.h
*********************************************************************/
