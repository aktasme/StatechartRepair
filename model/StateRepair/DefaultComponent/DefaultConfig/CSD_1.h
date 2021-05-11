/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: CSD_1
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\CSD_1.h
*********************************************************************/

#ifndef CSD_1_H
#define CSD_1_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include "_1_ComplexStatechartDiagram.h"
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _1_ComplexStatechartDiagram

//## class CSD_1
class CSD_1 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    CSD_1(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~CSD_1();
    
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
    
    // J:
    //## statechart_method
    inline bool J_IN() const;
    
    // I:
    //## statechart_method
    inline bool I_IN() const;
    
    //## statechart_method
    IOxfReactive::TakeEventStatus I_handleEvent();
    
    // H:
    //## statechart_method
    inline bool H_IN() const;
    
    // G:
    //## statechart_method
    inline bool G_IN() const;
    
    //## statechart_method
    IOxfReactive::TakeEventStatus G_handleEvent();
    
    // F:
    //## statechart_method
    inline bool F_IN() const;
    
    // E:
    //## statechart_method
    inline bool E_IN() const;
    
    //## statechart_method
    IOxfReactive::TakeEventStatus E_handleEvent();
    
    // D:
    //## statechart_method
    inline bool D_IN() const;
    
    // C:
    //## statechart_method
    inline bool C_IN() const;
    
    //## statechart_method
    IOxfReactive::TakeEventStatus C_handleEvent();
    
    // B:
    //## statechart_method
    inline bool B_IN() const;
    
    //## statechart_method
    IOxfReactive::TakeEventStatus B_handleEvent();
    
    ////    Framework    ////

protected :

//#[ ignore
    enum CSD_1_Enum {
        OMNonState = 0,
        A = 1,
        J = 2,
        I = 3,
        H = 4,
        G = 5,
        F = 6,
        E = 7,
        D = 8,
        C = 9,
        B = 10
    };
    
    int rootState_subState;
    
    int rootState_active;
    
    int A_subState;
//#]
};

inline bool CSD_1::rootState_IN() const {
    return true;
}

inline bool CSD_1::A_IN() const {
    return rootState_subState == A;
}

inline bool CSD_1::J_IN() const {
    return A_subState == J;
}

inline bool CSD_1::I_IN() const {
    return A_subState == I;
}

inline bool CSD_1::H_IN() const {
    return A_subState == H;
}

inline bool CSD_1::G_IN() const {
    return A_subState == G;
}

inline bool CSD_1::F_IN() const {
    return A_subState == F;
}

inline bool CSD_1::E_IN() const {
    return A_subState == E;
}

inline bool CSD_1::D_IN() const {
    return A_subState == D;
}

inline bool CSD_1::C_IN() const {
    return A_subState == C;
}

inline bool CSD_1::B_IN() const {
    return A_subState == B;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\CSD_1.h
*********************************************************************/
