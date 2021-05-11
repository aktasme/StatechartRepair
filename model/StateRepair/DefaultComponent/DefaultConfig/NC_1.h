/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: NC_1
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\NC_1.h
*********************************************************************/

#ifndef NC_1_H
#define NC_1_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _7_NestedConditions

//## class NC_1
class NC_1 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    NC_1(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~NC_1();
    
    ////    Additional operations    ////
    
    //## auto_generated
    int getA() const;
    
    //## auto_generated
    void setA(int p_a);
    
    //## auto_generated
    virtual bool startBehavior();

protected :

    //## auto_generated
    void initStatechart();
    
    ////    Attributes    ////
    
    int a;		//## attribute a
    
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
    
    ////    Framework    ////

protected :

//#[ ignore
    enum NC_1_Enum {
        OMNonState = 0,
        A = 1,
        F = 2,
        E = 3,
        D = 4,
        C = 5,
        B = 6
    };
    
    int rootState_subState;
    
    int rootState_active;
    
    int A_subState;
//#]
};

inline bool NC_1::rootState_IN() const {
    return true;
}

inline bool NC_1::A_IN() const {
    return rootState_subState == A;
}

inline bool NC_1::F_IN() const {
    return A_subState == F;
}

inline bool NC_1::E_IN() const {
    return A_subState == E;
}

inline bool NC_1::D_IN() const {
    return A_subState == D;
}

inline bool NC_1::C_IN() const {
    return A_subState == C;
}

inline bool NC_1::B_IN() const {
    return A_subState == B;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\NC_1.h
*********************************************************************/
