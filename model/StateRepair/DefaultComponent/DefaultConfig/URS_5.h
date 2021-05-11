/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: URS_5
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\URS_5.h
*********************************************************************/

#ifndef URS_5_H
#define URS_5_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _6_UnreachableState

//## class URS_5
class URS_5 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    URS_5(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~URS_5();
    
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
    
    //## statechart_method
    void A_exit();
    
    // H:
    //## statechart_method
    inline bool H_IN() const;
    
    // G:
    //## statechart_method
    inline bool G_IN() const;
    
    // F:
    //## statechart_method
    inline bool F_IN() const;
    
    // C:
    //## statechart_method
    inline bool C_IN() const;
    
    //## statechart_method
    void C_entDef();
    
    // E:
    //## statechart_method
    inline bool E_IN() const;
    
    // D:
    //## statechart_method
    inline bool D_IN() const;
    
    // B:
    //## statechart_method
    inline bool B_IN() const;
    
    ////    Framework    ////

protected :

//#[ ignore
    enum URS_5_Enum {
        OMNonState = 0,
        A = 1,
        H = 2,
        G = 3,
        F = 4,
        C = 5,
        E = 6,
        D = 7,
        B = 8
    };
    
    int rootState_subState;
    
    int rootState_active;
    
    int A_subState;
    
    int C_subState;
//#]
};

inline bool URS_5::rootState_IN() const {
    return true;
}

inline bool URS_5::A_IN() const {
    return rootState_subState == A;
}

inline bool URS_5::H_IN() const {
    return A_subState == H;
}

inline bool URS_5::G_IN() const {
    return A_subState == G;
}

inline bool URS_5::F_IN() const {
    return A_subState == F;
}

inline bool URS_5::C_IN() const {
    return A_subState == C;
}

inline bool URS_5::E_IN() const {
    return C_subState == E;
}

inline bool URS_5::D_IN() const {
    return C_subState == D;
}

inline bool URS_5::B_IN() const {
    return A_subState == B;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\URS_5.h
*********************************************************************/
