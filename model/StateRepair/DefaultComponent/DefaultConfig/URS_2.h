/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: URS_2
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\URS_2.h
*********************************************************************/

#ifndef URS_2_H
#define URS_2_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _5_UnreachableState

//## class URS_2
class URS_2 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    URS_2(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~URS_2();
    
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
    enum URS_2_Enum {
        OMNonState = 0,
        D = 1,
        C = 2,
        B = 3,
        A = 4
    };
    
    int rootState_subState;
    
    int rootState_active;
//#]
};

inline bool URS_2::rootState_IN() const {
    return true;
}

inline bool URS_2::D_IN() const {
    return rootState_subState == D;
}

inline bool URS_2::C_IN() const {
    return rootState_subState == C;
}

inline bool URS_2::B_IN() const {
    return rootState_subState == B;
}

inline bool URS_2::A_IN() const {
    return rootState_subState == A;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\URS_2.h
*********************************************************************/
