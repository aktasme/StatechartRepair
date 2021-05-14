/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TWCWOE_5
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_5.h
*********************************************************************/

#ifndef TWCWOE_5_H
#define TWCWOE_5_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _3_TransitionWithConditionWithoutEvent

//## class TWCWOE_5
class TWCWOE_5 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    TWCWOE_5(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~TWCWOE_5();
    
    ////    Additional operations    ////
    
    //## auto_generated
    unsigned int getX() const;
    
    //## auto_generated
    void setX(unsigned int p_x);
    
    //## auto_generated
    unsigned int getY() const;
    
    //## auto_generated
    void setY(unsigned int p_y);
    
    //## auto_generated
    virtual bool startBehavior();

protected :

    //## auto_generated
    void initStatechart();
    
    ////    Attributes    ////
    
    unsigned int x;		//## attribute x
    
    unsigned int y;		//## attribute y
    
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
    
    // D:
    //## statechart_method
    inline bool D_IN() const;
    
    //## statechart_method
    void D_entDef();
    
    // F:
    //## statechart_method
    inline bool F_IN() const;
    
    // E:
    //## statechart_method
    inline bool E_IN() const;
    
    // C:
    //## statechart_method
    inline bool C_IN() const;
    
    // B:
    //## statechart_method
    inline bool B_IN() const;
    
    ////    Framework    ////

protected :

//#[ ignore
    enum TWCWOE_5_Enum {
        OMNonState = 0,
        A = 1,
        D = 2,
        F = 3,
        E = 4,
        C = 5,
        B = 6
    };
    
    int rootState_subState;
    
    int rootState_active;
    
    int A_subState;
    
    int D_subState;
//#]
};

inline bool TWCWOE_5::rootState_IN() const {
    return true;
}

inline bool TWCWOE_5::A_IN() const {
    return rootState_subState == A;
}

inline bool TWCWOE_5::D_IN() const {
    return A_subState == D;
}

inline bool TWCWOE_5::F_IN() const {
    return D_subState == F;
}

inline bool TWCWOE_5::E_IN() const {
    return D_subState == E;
}

inline bool TWCWOE_5::C_IN() const {
    return A_subState == C;
}

inline bool TWCWOE_5::B_IN() const {
    return A_subState == B;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_5.h
*********************************************************************/
