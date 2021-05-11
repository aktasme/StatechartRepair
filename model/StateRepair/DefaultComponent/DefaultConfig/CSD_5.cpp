/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: CSD_5
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\CSD_5.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "CSD_5.h"
//## event evA()
#include "Default.h"
//## package _1_ComplexStatechartDiagram

//## class CSD_5
CSD_5::CSD_5(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

CSD_5::~CSD_5() {
}

bool CSD_5::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void CSD_5::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
}

void CSD_5::rootState_entDef() {
    {
        rootState_subState = A;
        rootState_active = A;
    }
}

IOxfReactive::TakeEventStatus CSD_5::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State A
        case A:
        {
            if(IS_EVENT_TYPE_OF(evAA_Default_id))
                {
                    rootState_subState = A;
                    rootState_active = A;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evAB_Default_id))
                {
                    rootState_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evA_Default_id))
                {
                    rootState_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            
        }
        break;
        // State B
        case B:
        {
            if(IS_EVENT_TYPE_OF(evBB_Default_id))
                {
                    rootState_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evB_Default_id))
                {
                    rootState_subState = A;
                    rootState_active = A;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evBA_Default_id))
                {
                    rootState_subState = A;
                    rootState_active = A;
                    res = eventConsumed;
                }
            
        }
        break;
        default:
            break;
    }
    return res;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\CSD_5.cpp
*********************************************************************/
