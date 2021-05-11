/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TBSWDH_3
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TBSWDH_3.h
*********************************************************************/

#ifndef TBSWDH_3_H
#define TBSWDH_3_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _2_TransitionBetweenStatesWithDifferentHierarchy

//## class TBSWDH_3
class TBSWDH_3 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    TBSWDH_3(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~TBSWDH_3();
    
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
    enum TBSWDH_3_Enum {
        OMNonState = 0,
        A = 1,
        C = 2,
        E = 3,
        D = 4,
        B = 5
    };
    
    int rootState_subState;
    
    int rootState_active;
    
    int A_subState;
    
    int C_subState;
//#]
};

inline bool TBSWDH_3::rootState_IN() const {
    return true;
}

inline bool TBSWDH_3::A_IN() const {
    return rootState_subState == A;
}

inline bool TBSWDH_3::C_IN() const {
    return A_subState == C;
}

inline bool TBSWDH_3::E_IN() const {
    return C_subState == E;
}

inline bool TBSWDH_3::D_IN() const {
    return C_subState == D;
}

inline bool TBSWDH_3::B_IN() const {
    return A_subState == B;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TBSWDH_3.h
*********************************************************************/
