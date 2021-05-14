/*********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: CSD_5
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\CSD_5.h
*********************************************************************/

#ifndef CSD_5_H
#define CSD_5_H

//## auto_generated
#include <oxf\oxf.h>
//## auto_generated
#include <oxf\omreactive.h>
//## auto_generated
#include <oxf\state.h>
//## auto_generated
#include <oxf\event.h>
//## package _1_ComplexStatechartDiagram

//## class CSD_5
class CSD_5 : public OMReactive {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    CSD_5(IOxfActive* theActiveContext = 0);
    
    //## auto_generated
    ~CSD_5();
    
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
    
    // B:
    //## statechart_method
    inline bool B_IN() const;
    
    // A:
    //## statechart_method
    inline bool A_IN() const;
    
    ////    Framework    ////

protected :

//#[ ignore
    enum CSD_5_Enum {
        OMNonState = 0,
        B = 1,
        A = 2
    };
    
    int rootState_subState;
    
    int rootState_active;
//#]
};

inline bool CSD_5::rootState_IN() const {
    return true;
}

inline bool CSD_5::B_IN() const {
    return rootState_subState == B;
}

inline bool CSD_5::A_IN() const {
    return rootState_subState == A;
}

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\CSD_5.h
*********************************************************************/
