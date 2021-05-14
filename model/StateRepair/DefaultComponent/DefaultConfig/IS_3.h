/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: IS_3
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\IS_3.h
*********************************************************************/

#ifndef IS_3_H
#define IS_3_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package Candidates::_5_IsolatedState

//## class IS_3
class IS_3 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    IS_3(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~IS_3();
    
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
    enum IS_3_Enum {
        OMNonState = 0,
        E = 1,
        D = 2,
        A = 3,
        C = 4,
        B = 5
    };
    
    int rootState_subState;
    
    int rootState_active;
    
    int A_subState;
//#]
};

inline bool IS_3::rootState_IN() const {
    return true;
}

inline bool IS_3::E_IN() const {
    return rootState_subState == E;
}

inline bool IS_3::D_IN() const {
    return rootState_subState == D;
}

inline bool IS_3::A_IN() const {
    return rootState_subState == A;
}

inline bool IS_3::C_IN() const {
    return A_subState == C;
}

inline bool IS_3::B_IN() const {
    return A_subState == B;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\IS_3.h
*********************************************************************/
