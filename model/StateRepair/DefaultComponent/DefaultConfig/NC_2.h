/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: NC_2
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\NC_2.h
*********************************************************************/

#ifndef NC_2_H
#define NC_2_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _7_NestedConditions

//## class NC_2
class NC_2 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    NC_2(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~NC_2();
    
    ////    Additional operations    ////
    
    //## auto_generated
    int getX() const;
    
    //## auto_generated
    void setX(int p_x);
    
    //## auto_generated
    virtual bool startBehavior();

protected :

    //## auto_generated
    void initStatechart();
    
    ////    Attributes    ////
    
    int x;		//## attribute x
    
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
    
    // B:
    //## statechart_method
    inline bool B_IN() const;
    
    // A:
    //## statechart_method
    inline bool A_IN() const;
    
    ////    Framework    ////

protected :

//#[ ignore
    enum NC_2_Enum {
        OMNonState = 0,
        C = 1,
        B = 2,
        A = 3
    };
    
    int rootState_subState;
    
    int rootState_active;
//#]
};

inline bool NC_2::rootState_IN() const {
    return true;
}

inline bool NC_2::C_IN() const {
    return rootState_subState == C;
}

inline bool NC_2::B_IN() const {
    return rootState_subState == B;
}

inline bool NC_2::A_IN() const {
    return rootState_subState == A;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\NC_2.h
*********************************************************************/
