/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: CSD_3
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\CSD_3.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "CSD_3.h"
//## event evAD()
#include "Default.h"
//## package _1_ComplexStatechartDiagram

//## class CSD_3
CSD_3::CSD_3(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

CSD_3::~CSD_3() {
}

bool CSD_3::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void CSD_3::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
}

void CSD_3::rootState_entDef() {
    {
        rootState_subState = A;
        rootState_active = A;
    }
}

IOxfReactive::TakeEventStatus CSD_3::rootState_processEvent() {
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
            else if(IS_EVENT_TYPE_OF(evAD_Default_id))
                {
                    rootState_subState = D;
                    rootState_active = D;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evAE_Default_id))
                {
                    rootState_subState = E;
                    rootState_active = E;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evAF_Default_id))
                {
                    rootState_subState = F;
                    rootState_active = F;
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
            else if(IS_EVENT_TYPE_OF(evBD_Default_id))
                {
                    rootState_subState = D;
                    rootState_active = D;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evBE_Default_id))
                {
                    rootState_subState = E;
                    rootState_active = E;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evBF_Default_id))
                {
                    rootState_subState = F;
                    rootState_active = F;
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
            else if(IS_EVENT_TYPE_OF(evCE_Default_id))
                {
                    rootState_subState = E;
                    rootState_active = E;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evCF_Default_id))
                {
                    rootState_subState = F;
                    rootState_active = F;
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
            
        }
        break;
        // State E
        case E:
        {
            if(IS_EVENT_TYPE_OF(evED_Default_id))
                {
                    rootState_subState = D;
                    rootState_active = D;
                    res = eventConsumed;
                }
            
        }
        break;
        // State F
        case F:
        {
            if(IS_EVENT_TYPE_OF(evFE_Default_id))
                {
                    rootState_subState = E;
                    rootState_active = E;
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
	File Path	: DefaultComponent\DefaultConfig\CSD_3.cpp
*********************************************************************/
