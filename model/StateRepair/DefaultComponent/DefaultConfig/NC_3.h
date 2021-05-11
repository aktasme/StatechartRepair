/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: NC_3
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\NC_3.h
*********************************************************************/

#ifndef NC_3_H
#define NC_3_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _7_NestedConditions

//## class NC_3
class NC_3 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    NC_3(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~NC_3();
    
    ////    Additional operations    ////
    
    //## auto_generated
    int getX() const;
    
    //## auto_generated
    void setX(int p_x);
    
    //## auto_generated
    int getY() const;
    
    //## auto_generated
    void setY(int p_y);
    
    //## auto_generated
    virtual bool startBehavior();

protected :

    //## auto_generated
    void initStatechart();
    
    ////    Attributes    ////
    
    int x;		//## attribute x
    
    int y;		//## attribute y
    
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
    
    //## statechart_method
    IOxfReactive::TakeEventStatus ATakeevA();
    
    //## statechart_method
    IOxfReactive::TakeEventStatus A_handleEvent();
    
    ////    Framework    ////

protected :

//#[ ignore
    enum NC_3_Enum {
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

inline bool NC_3::rootState_IN() const {
    return true;
}

inline bool NC_3::D_IN() const {
    return rootState_subState == D;
}

inline bool NC_3::C_IN() const {
    return rootState_subState == C;
}

inline bool NC_3::B_IN() const {
    return rootState_subState == B;
}

inline bool NC_3::A_IN() const {
    return rootState_subState == A;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\NC_3.h
*********************************************************************/
