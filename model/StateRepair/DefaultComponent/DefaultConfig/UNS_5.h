/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: UNS_5
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\UNS_5.h
*********************************************************************/

#ifndef UNS_5_H
#define UNS_5_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _8_UnnecessaryState

//## class UNS_5
class UNS_5 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    UNS_5(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~UNS_5();
    
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
    
    // C:
    //## statechart_method
    inline bool C_IN() const;
    
    // B:
    //## statechart_method
    inline bool B_IN() const;
    
    // A:
    //## statechart_method
    inline bool A_IN() const;
    
    ////    Framework    ////

protected :

//#[ ignore
    enum UNS_5_Enum {
        OMNonState = 0,
        C = 1,
        B = 2,
        A = 3
    };
    
    int rootState_subState;
    
    int rootState_active;
//#]
};

inline bool UNS_5::rootState_IN() const {
    return true;
}

inline bool UNS_5::C_IN() const {
    return rootState_subState == C;
}

inline bool UNS_5::B_IN() const {
    return rootState_subState == B;
}

inline bool UNS_5::A_IN() const {
    return rootState_subState == A;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\UNS_5.h
*********************************************************************/
