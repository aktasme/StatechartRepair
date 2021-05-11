/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TBSWDH_2
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TBSWDH_2.h
*********************************************************************/

#ifndef TBSWDH_2_H
#define TBSWDH_2_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _2_TransitionBetweenStatesWithDifferentHierarchy

//## class TBSWDH_2
class TBSWDH_2 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    TBSWDH_2(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~TBSWDH_2();
    
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
    
    // A:
    //## statechart_method
    inline bool A_IN() const;
    
    //## statechart_method
    void A_entDef();
    
    // B:
    //## statechart_method
    inline bool B_IN() const;
    
    ////    Framework    ////

protected :

//#[ ignore
    enum TBSWDH_2_Enum {
        OMNonState = 0,
        C = 1,
        A = 2,
        B = 3
    };
    
    int rootState_subState;
    
    int rootState_active;
    
    int A_subState;
//#]
};

inline bool TBSWDH_2::rootState_IN() const {
    return true;
}

inline bool TBSWDH_2::C_IN() const {
    return rootState_subState == C;
}

inline bool TBSWDH_2::A_IN() const {
    return rootState_subState == A;
}

inline bool TBSWDH_2::B_IN() const {
    return A_subState == B;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TBSWDH_2.h
*********************************************************************/
