/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: UNS_1
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\UNS_1.h
*********************************************************************/

#ifndef UNS_1_H
#define UNS_1_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _8_UnnecessaryState

//## class UNS_1
class UNS_1 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    UNS_1(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~UNS_1();
    
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
    
    // E:
    //## statechart_method
    inline bool E_IN() const;
    
    // D:
    //## statechart_method
    inline bool D_IN() const;
    
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
    enum UNS_1_Enum {
        OMNonState = 0,
        E = 1,
        D = 2,
        C = 3,
        B = 4,
        A = 5
    };
    
    int rootState_subState;
    
    int rootState_active;
//#]
};

inline bool UNS_1::rootState_IN() const {
    return true;
}

inline bool UNS_1::E_IN() const {
    return rootState_subState == E;
}

inline bool UNS_1::D_IN() const {
    return rootState_subState == D;
}

inline bool UNS_1::C_IN() const {
    return rootState_subState == C;
}

inline bool UNS_1::B_IN() const {
    return rootState_subState == B;
}

inline bool UNS_1::A_IN() const {
    return rootState_subState == A;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\UNS_1.h
*********************************************************************/
