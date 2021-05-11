/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TWCWOE_2
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_2.h
*********************************************************************/

#ifndef TWCWOE_2_H
#define TWCWOE_2_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _3_TransitionWithConditionWithoutEvent

//## class TWCWOE_2
class TWCWOE_2 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    TWCWOE_2(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~TWCWOE_2();
    
    ////    Additional operations    ////
    
    //## auto_generated
    unsigned int getX() const;
    
    //## auto_generated
    void setX(unsigned int p_x);
    
    //## auto_generated
    virtual bool startBehavior();

protected :

    //## auto_generated
    void initStatechart();
    
    ////    Attributes    ////
    
    unsigned int x;		//## attribute x
    
    ////    Framework operations    ////

public :

    // rootState:
    //## statechart_method
    inline bool rootState_IN() const;
    
    //## statechart_method
    virtual void rootState_entDef();
    
    //## statechart_method
    virtual IOxfReactive::TakeEventStatus rootState_processEvent();
    
    // B:
    //## statechart_method
    inline bool B_IN() const;
    
    // A:
    //## statechart_method
    inline bool A_IN() const;
    
    ////    Framework    ////

protected :

//#[ ignore
    enum TWCWOE_2_Enum {
        OMNonState = 0,
        B = 1,
        A = 2
    };
    
    int rootState_subState;
    
    int rootState_active;
//#]
};

inline bool TWCWOE_2::rootState_IN() const {
    return true;
}

inline bool TWCWOE_2::B_IN() const {
    return rootState_subState == B;
}

inline bool TWCWOE_2::A_IN() const {
    return rootState_subState == A;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_2.h
*********************************************************************/
