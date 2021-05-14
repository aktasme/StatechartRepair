/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: CSD_2
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\CSD_2.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "CSD_2.h"
//## event evA()
#include "Default.h"
//## package _1_ComplexStatechartDiagram

//## class CSD_2
CSD_2::CSD_2(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

CSD_2::~CSD_2() {
}

bool CSD_2::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void CSD_2::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
}

bool CSD_2::getA() const {
    return a;
}

void CSD_2::setA(bool p_a) {
    a = p_a;
}

bool CSD_2::getB() const {
    return b;
}

void CSD_2::setB(bool p_b) {
    b = p_b;
}

bool CSD_2::getC() const {
    return c;
}

void CSD_2::setC(bool p_c) {
    c = p_c;
}

void CSD_2::rootState_entDef() {
    {
        rootState_subState = A;
        rootState_active = A;
    }
}

IOxfReactive::TakeEventStatus CSD_2::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State A
        case A:
        {
            if(IS_EVENT_TYPE_OF(evA_Default_id))
                {
                    //## transition 2 
                    if(b)
                        {
                            rootState_subState = B;
                            rootState_active = B;
                            res = eventConsumed;
                        }
                    else
                        {
                            rootState_subState = C;
                            rootState_active = C;
                            res = eventConsumed;
                        }
                }
            
        }
        break;
        // State B
        case B:
        {
            if(IS_EVENT_TYPE_OF(evB_Default_id))
                {
                    if(TRUE)
                        {
                            rootState_subState = C;
                            rootState_active = C;
                            res = eventConsumed;
                        }
                }
            
        }
        break;
        // State C
        case C:
        {
            if(IS_EVENT_TYPE_OF(evC_Default_id))
                {
                    //## transition 5 
                    if(b)
                        {
                            rootState_subState = B;
                            rootState_active = B;
                            res = eventConsumed;
                        }
                    else
                        {
                            rootState_subState = A;
                            rootState_active = A;
                            res = eventConsumed;
                        }
                }
            
        }
        break;
        default:
            break;
    }
    return res;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\CSD_2.cpp
*********************************************************************/
