/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TWCWOE_1
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_1.h
*********************************************************************/

#ifndef TWCWOE_1_H
#define TWCWOE_1_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _3_TransitionWithConditionWithoutEvent

//## class TWCWOE_1
class TWCWOE_1 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    TWCWOE_1(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~TWCWOE_1();
    
    ////    Additional operations    ////
    
    //## auto_generated
    bool getX() const;
    
    //## auto_generated
    void setX(bool p_x);
    
    //## auto_generated
    virtual bool startBehavior();

protected :

    //## auto_generated
    void initStatechart();
    
    ////    Attributes    ////
    
    bool x;		//## attribute x
    
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
    
    // B:
    //## statechart_method
    inline bool B_IN() const;
    
    ////    Framework    ////

protected :

//#[ ignore
    enum TWCWOE_1_Enum {
        OMNonState = 0,
        A = 1,
        C = 2,
        B = 3
    };
    
    int rootState_subState;
    
    int rootState_active;
    
    int A_subState;
//#]
};

inline bool TWCWOE_1::rootState_IN() const {
    return true;
}

inline bool TWCWOE_1::A_IN() const {
    return rootState_subState == A;
}

inline bool TWCWOE_1::C_IN() const {
    return A_subState == C;
}

inline bool TWCWOE_1::B_IN() const {
    return A_subState == B;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_1.h
*********************************************************************/
