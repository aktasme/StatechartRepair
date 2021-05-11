/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: ISN_2
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\ISN_2.h
*********************************************************************/

#ifndef ISN_2_H
#define ISN_2_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _4_InvalidStateName

//## class ISN_2
class ISN_2 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    ISN_2(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~ISN_2();
    
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
    
    // state_0:
    //## statechart_method
    inline bool state_0_IN() const;
    
    //## statechart_method
    void state_0_entDef();
    
    // B:
    //## statechart_method
    inline bool B_IN() const;
    
    // A:
    //## statechart_method
    inline bool A_IN() const;
    
    ////    Framework    ////

protected :

//#[ ignore
    enum ISN_2_Enum {
        OMNonState = 0,
        state_0 = 1,
        B = 2,
        A = 3
    };
    
    int rootState_subState;
    
    int rootState_active;
    
    int state_0_subState;
//#]
};

inline bool ISN_2::rootState_IN() const {
    return true;
}

inline bool ISN_2::state_0_IN() const {
    return rootState_subState == state_0;
}

inline bool ISN_2::B_IN() const {
    return state_0_subState == B;
}

inline bool ISN_2::A_IN() const {
    return state_0_subState == A;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\ISN_2.h
*********************************************************************/
