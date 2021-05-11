/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: ISN_3
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\ISN_3.h
*********************************************************************/

#ifndef ISN_3_H
#define ISN_3_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _4_InvalidStateName

//## class ISN_3
class ISN_3 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    ISN_3(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~ISN_3();
    
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
    
    // A:
    //## statechart_method
    inline bool A_IN() const;
    
    //## statechart_method
    void A_entDef();
    
    // state_3:
    //## statechart_method
    inline bool state_3_IN() const;
    
    // B:
    //## statechart_method
    inline bool B_IN() const;
    
    ////    Framework    ////

protected :

//#[ ignore
    enum ISN_3_Enum {
        OMNonState = 0,
        A = 1,
        state_3 = 2,
        B = 3
    };
    
    int rootState_subState;
    
    int rootState_active;
    
    int A_subState;
//#]
};

inline bool ISN_3::rootState_IN() const {
    return true;
}

inline bool ISN_3::A_IN() const {
    return rootState_subState == A;
}

inline bool ISN_3::state_3_IN() const {
    return A_subState == state_3;
}

inline bool ISN_3::B_IN() const {
    return A_subState == B;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\ISN_3.h
*********************************************************************/
