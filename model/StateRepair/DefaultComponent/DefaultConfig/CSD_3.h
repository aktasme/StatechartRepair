/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: CSD_3
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\CSD_3.h
*********************************************************************/

#ifndef CSD_3_H
#define CSD_3_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _1_ComplexStatechartDiagram

//## class CSD_3
class CSD_3 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    CSD_3(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~CSD_3();
    
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
    enum CSD_3_Enum {
        OMNonState = 0,
        F = 1,
        E = 2,
        D = 3,
        C = 4,
        B = 5,
        A = 6
    };
    
    int rootState_subState;
    
    int rootState_active;
//#]
};

inline bool CSD_3::rootState_IN() const {
    return true;
}

inline bool CSD_3::F_IN() const {
    return rootState_subState == F;
}

inline bool CSD_3::E_IN() const {
    return rootState_subState == E;
}

inline bool CSD_3::D_IN() const {
    return rootState_subState == D;
}

inline bool CSD_3::C_IN() const {
    return rootState_subState == C;
}

inline bool CSD_3::B_IN() const {
    return rootState_subState == B;
}

inline bool CSD_3::A_IN() const {
    return rootState_subState == A;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\CSD_3.h
*********************************************************************/
