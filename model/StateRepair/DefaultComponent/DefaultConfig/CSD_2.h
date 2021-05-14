/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: CSD_2
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\CSD_2.h
*********************************************************************/

#ifndef CSD_2_H
#define CSD_2_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _1_ComplexStatechartDiagram

//## class CSD_2
class CSD_2 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    CSD_2(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~CSD_2();
    
    ////    Additional operations    ////
    
    //## auto_generated
    virtual bool startBehavior();

protected :

    //## auto_generated
    void initStatechart();

private :

    //## auto_generated
    bool getA() const;
    
    //## auto_generated
    void setA(bool p_a);
    
    //## auto_generated
    bool getB() const;
    
    //## auto_generated
    void setB(bool p_b);
    
    //## auto_generated
    bool getC() const;
    
    //## auto_generated
    void setC(bool p_c);
    
    ////    Attributes    ////

protected :

    bool a;		//## attribute a
    
    bool b;		//## attribute b
    
    bool c;		//## attribute c
    
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
    enum CSD_2_Enum {
        OMNonState = 0,
        C = 1,
        B = 2,
        A = 3
    };
    
    int rootState_subState;
    
    int rootState_active;
//#]
};

inline bool CSD_2::rootState_IN() const {
    return true;
}

inline bool CSD_2::C_IN() const {
    return rootState_subState == C;
}

inline bool CSD_2::B_IN() const {
    return rootState_subState == B;
}

inline bool CSD_2::A_IN() const {
    return rootState_subState == A;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\CSD_2.h
*********************************************************************/
