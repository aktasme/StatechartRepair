/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: CSD_4
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\CSD_4.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "CSD_4.h"
//## event evAB()
#include "Default.h"
//## package _1_ComplexStatechartDiagram

//## class CSD_4
CSD_4::CSD_4(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

CSD_4::~CSD_4() {
}

bool CSD_4::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void CSD_4::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
}

void CSD_4::rootState_entDef() {
    {
        rootState_subState = A;
        rootState_active = A;
    }
}

IOxfReactive::TakeEventStatus CSD_4::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State A
        case A:
        {
            if(IS_EVENT_TYPE_OF(evAB_Default_id))
                {
                    rootState_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evAC__1_ComplexStatechartDiagram_id))
                {
                    rootState_subState = C;
                    rootState_active = C;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evAD_Default_id))
                {
                    rootState_subState = D;
                    rootState_active = D;
                    res = eventConsumed;
                }
            
        }
        break;
        // State B
        case B:
        {
            if(IS_EVENT_TYPE_OF(evBC_Default_id))
                {
                    rootState_subState = C;
                    rootState_active = C;
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
        // State C
        case C:
        {
            if(IS_EVENT_TYPE_OF(evCD_Default_id))
                {
                    rootState_subState = D;
                    rootState_active = D;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evCB_Default_id))
                {
                    rootState_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            
        }
        break;
        // State D
        case D:
        {
            if(IS_EVENT_TYPE_OF(evDA_Default_id))
                {
                    rootState_subState = A;
                    rootState_active = A;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evDB__1_ComplexStatechartDiagram_id))
                {
                    rootState_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evDC_Default_id))
                {
                    rootState_subState = C;
                    rootState_active = C;
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
	File Path	: DefaultComponent\DefaultConfig\CSD_4.cpp
*********************************************************************/
