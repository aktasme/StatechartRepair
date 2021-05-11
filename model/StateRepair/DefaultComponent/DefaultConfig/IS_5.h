/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: IS_5
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\IS_5.h
*********************************************************************/

#ifndef IS_5_H
#define IS_5_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _5_IsolatedState

//## class IS_5
class IS_5 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    IS_5(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~IS_5();
    
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
    
    // F:
    //## statechart_method
    inline bool F_IN() const;
    
    // E:
    //## statechart_method
    inline bool E_IN() const;
    
    //## statechart_method
    void E_entDef();
    
    // D:
    //## statechart_method
    inline bool D_IN() const;
    
    // B:
    //## statechart_method
    inline bool B_IN() const;
    
    // C:
    //## statechart_method
    inline bool C_IN() const;
    
    // A:
    //## statechart_method
    inline bool A_IN() const;
    
    ////    Framework    ////

protected :

//#[ ignore
    enum IS_5_Enum {
        OMNonState = 0,
        F = 1,
        E = 2,
        D = 3,
        B = 4,
        C = 5,
        A = 6
    };
    
    int rootState_subState;
    
    int rootState_active;
    
    int E_subState;
//#]
};

inline bool IS_5::rootState_IN() const {
    return true;
}

inline bool IS_5::F_IN() const {
    return rootState_subState == F;
}

inline bool IS_5::E_IN() const {
    return rootState_subState == E;
}

inline bool IS_5::D_IN() const {
    return E_subState == D;
}

inline bool IS_5::B_IN() const {
    return E_subState == B;
}

inline bool IS_5::C_IN() const {
    return rootState_subState == C;
}

inline bool IS_5::A_IN() const {
    return rootState_subState == A;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\IS_5.h
*********************************************************************/
