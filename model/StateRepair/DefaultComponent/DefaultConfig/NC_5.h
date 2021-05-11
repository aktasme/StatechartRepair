/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: NC_5
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\NC_5.h
*********************************************************************/

#ifndef NC_5_H
#define NC_5_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _7_NestedConditions

//## class NC_5
class NC_5 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    NC_5(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~NC_5();
    
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
    
    // A:
    //## statechart_method
    inline bool A_IN() const;
    
    //## statechart_method
    void A_entDef();
    
    // E:
    //## statechart_method
    inline bool E_IN() const;
    
    // C:
    //## statechart_method
    inline bool C_IN() const;
    
    //## statechart_method
    void C_entDef();
    
    // D:
    //## statechart_method
    inline bool D_IN() const;
    
    // C_B:
    //## statechart_method
    inline bool C_B_IN() const;
    
    // B:
    //## statechart_method
    inline bool B_IN() const;
    
    //## statechart_method
    IOxfReactive::TakeEventStatus B_handleEvent();
    
    ////    Framework    ////

protected :

//#[ ignore
    enum NC_5_Enum {
        OMNonState = 0,
        A = 1,
        E = 2,
        C = 3,
        D = 4,
        C_B = 5,
        B = 6
    };
    
    int rootState_subState;
    
    int rootState_active;
    
    int A_subState;
    
    int C_subState;
//#]
};

inline bool NC_5::rootState_IN() const {
    return true;
}

inline bool NC_5::A_IN() const {
    return rootState_subState == A;
}

inline bool NC_5::E_IN() const {
    return A_subState == E;
}

inline bool NC_5::C_IN() const {
    return A_subState == C;
}

inline bool NC_5::D_IN() const {
    return C_subState == D;
}

inline bool NC_5::C_B_IN() const {
    return C_subState == C_B;
}

inline bool NC_5::B_IN() const {
    return A_subState == B;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\NC_5.h
*********************************************************************/
