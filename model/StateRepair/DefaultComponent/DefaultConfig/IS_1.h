/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: IS_1
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\IS_1.h
*********************************************************************/

#ifndef IS_1_H
#define IS_1_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package Candidates::_5_IsolatedState

//## class IS_1
class IS_1 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    IS_1(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~IS_1();
    
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
    
    // D:
    //## statechart_method
    inline bool D_IN() const;
    
    // A:
    //## statechart_method
    inline bool A_IN() const;
    
    //## statechart_method
    void A_entDef();
    
    // C:
    //## statechart_method
    inline bool C_IN() const;
    
    // B:
    //## statechart_method
    inline bool B_IN() const;
    
    ////    Framework    ////

protected :

//#[ ignore
    enum IS_1_Enum {
        OMNonState = 0,
        D = 1,
        A = 2,
        C = 3,
        B = 4
    };
    
    int rootState_subState;
    
    int rootState_active;
    
    int A_subState;
//#]
};

inline bool IS_1::rootState_IN() const {
    return true;
}

inline bool IS_1::D_IN() const {
    return rootState_subState == D;
}

inline bool IS_1::A_IN() const {
    return rootState_subState == A;
}

inline bool IS_1::C_IN() const {
    return A_subState == C;
}

inline bool IS_1::B_IN() const {
    return A_subState == B;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\IS_1.h
*********************************************************************/
