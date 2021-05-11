/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: NC_4
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\NC_4.h
*********************************************************************/

#ifndef NC_4_H
#define NC_4_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _7_NestedConditions

//## class NC_4
class NC_4 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    NC_4(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~NC_4();
    
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
    enum NC_4_Enum {
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

inline bool NC_4::rootState_IN() const {
    return true;
}

inline bool NC_4::D_IN() const {
    return rootState_subState == D;
}

inline bool NC_4::C_IN() const {
    return rootState_subState == C;
}

inline bool NC_4::B_IN() const {
    return rootState_subState == B;
}

inline bool NC_4::A_IN() const {
    return rootState_subState == A;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\NC_4.h
*********************************************************************/
