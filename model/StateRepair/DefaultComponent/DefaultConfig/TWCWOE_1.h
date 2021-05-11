/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TWCWOE_1
//!	Generated Date	: Sat, 2, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_1.h
*********************************************************************/

#ifndef TWCWOE_1_H
#define TWCWOE_1_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _3_TransitionWithConditionWithoutEvent

//## class TWCWOE_1
class TWCWOE_1 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    TWCWOE_1(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~TWCWOE_1();
    
    ////    Additional operations    ////
    
    //## auto_generated
    bool getIsAutoFocusFinished() const;
    
    //## auto_generated
    void setIsAutoFocusFinished(bool p_isAutoFocusFinished);
    
    //## auto_generated
    virtual bool startBehavior();

protected :

    //## auto_generated
    void initStatechart();
    
    ////    Attributes    ////
    
    bool isAutoFocusFinished;		//## attribute isAutoFocusFinished
    
    ////    Framework operations    ////

public :

    // rootState:
    //## statechart_method
    inline bool rootState_IN() const;
    
    //## statechart_method
    virtual void rootState_entDef();
    
    //## statechart_method
    virtual IOxfReactive::TakeEventStatus rootState_processEvent();
    
    // AutoFocus:
    //## statechart_method
    inline bool AutoFocus_IN() const;
    
    //## statechart_method
    void AutoFocus_entDef();
    
    // Idle:
    //## statechart_method
    inline bool Idle_IN() const;
    
    // AutoFocusInProgress:
    //## statechart_method
    inline bool AutoFocusInProgress_IN() const;
    
    ////    Framework    ////

protected :

//#[ ignore
    enum TWCWOE_1_Enum {
        OMNonState = 0,
        AutoFocus = 1,
        Idle = 2,
        AutoFocusInProgress = 3
    };
    
    int rootState_subState;
    
    int rootState_active;
    
    int AutoFocus_subState;
//#]
};

inline bool TWCWOE_1::rootState_IN() const {
    return true;
}

inline bool TWCWOE_1::AutoFocus_IN() const {
    return rootState_subState == AutoFocus;
}

inline bool TWCWOE_1::Idle_IN() const {
    return AutoFocus_subState == Idle;
}

inline bool TWCWOE_1::AutoFocusInProgress_IN() const {
    return AutoFocus_subState == AutoFocusInProgress;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_1.h
*********************************************************************/
