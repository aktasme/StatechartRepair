/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: CSD_1
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\CSD_1.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "CSD_1.h"
//## event evBC()
#include "Default.h"
//## package _1_ComplexStatechartDiagram

//## class CSD_1
CSD_1::CSD_1(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

CSD_1::~CSD_1() {
}

bool CSD_1::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void CSD_1::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
}

void CSD_1::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus CSD_1::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State B
        case B:
        {
            res = B_handleEvent();
        }
        break;
        // State C
        case C:
        {
            res = C_handleEvent();
        }
        break;
        // State D
        case D:
        {
            if(IS_EVENT_TYPE_OF(evDC_Default_id))
                {
                    A_subState = C;
                    rootState_active = C;
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State E
        case E:
        {
            res = E_handleEvent();
        }
        break;
        // State F
        case F:
        {
            if(IS_EVENT_TYPE_OF(evFE_Default_id))
                {
                    A_subState = E;
                    rootState_active = E;
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State G
        case G:
        {
            res = G_handleEvent();
        }
        break;
        // State I
        case I:
        {
            res = I_handleEvent();
        }
        break;
        // State H
        case H:
        {
            if(IS_EVENT_TYPE_OF(evHG_Default_id))
                {
                    A_subState = G;
                    rootState_active = G;
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State J
        case J:
        {
            if(IS_EVENT_TYPE_OF(evJI_Default_id))
                {
                    A_subState = I;
                    rootState_active = I;
                    res = eventConsumed;
                }
            
            
        }
        break;
        default:
            break;
    }
    return res;
}

void CSD_1::A_entDef() {
    rootState_subState = A;
    A_subState = B;
    rootState_active = B;
}

void CSD_1::A_exit() {
    A_subState = OMNonState;
    
}

IOxfReactive::TakeEventStatus CSD_1::I_handleEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    if(IS_EVENT_TYPE_OF(evIJ_Default_id))
        {
            A_subState = J;
            rootState_active = J;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evIB_Default_id))
        {
            A_subState = B;
            rootState_active = B;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evIC_Default_id))
        {
            A_subState = C;
            rootState_active = C;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evIE_Default_id))
        {
            A_subState = E;
            rootState_active = E;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evIG_Default_id))
        {
            A_subState = G;
            rootState_active = G;
            res = eventConsumed;
        }
    
    
    return res;
}

IOxfReactive::TakeEventStatus CSD_1::G_handleEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    if(IS_EVENT_TYPE_OF(evGH_Default_id))
        {
            A_subState = H;
            rootState_active = H;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evGI_Default_id))
        {
            A_subState = I;
            rootState_active = I;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evGB_Default_id))
        {
            A_subState = B;
            rootState_active = B;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evGC_Default_id))
        {
            A_subState = C;
            rootState_active = C;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evGE_Default_id))
        {
            A_subState = E;
            rootState_active = E;
            res = eventConsumed;
        }
    
    
    return res;
}

IOxfReactive::TakeEventStatus CSD_1::E_handleEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    if(IS_EVENT_TYPE_OF(evEF_Default_id))
        {
            A_subState = F;
            rootState_active = F;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evEG_Default_id))
        {
            A_subState = G;
            rootState_active = G;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evEI_Default_id))
        {
            A_subState = I;
            rootState_active = I;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evEB_Default_id))
        {
            A_subState = B;
            rootState_active = B;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evEC_Default_id))
        {
            A_subState = C;
            rootState_active = C;
            res = eventConsumed;
        }
    
    
    return res;
}

IOxfReactive::TakeEventStatus CSD_1::C_handleEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    if(IS_EVENT_TYPE_OF(evCD_Default_id))
        {
            A_subState = D;
            rootState_active = D;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evCE_Default_id))
        {
            A_subState = E;
            rootState_active = E;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evCG_Default_id))
        {
            A_subState = G;
            rootState_active = G;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evCI_Default_id))
        {
            A_subState = I;
            rootState_active = I;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evCB_Default_id))
        {
            A_subState = B;
            rootState_active = B;
            res = eventConsumed;
        }
    
    
    return res;
}

IOxfReactive::TakeEventStatus CSD_1::B_handleEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    if(IS_EVENT_TYPE_OF(evBC_Default_id))
        {
            A_subState = C;
            rootState_active = C;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evBE_Default_id))
        {
            A_subState = E;
            rootState_active = E;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evBG_Default_id))
        {
            A_subState = G;
            rootState_active = G;
            res = eventConsumed;
        }
    else if(IS_EVENT_TYPE_OF(evBI_Default_id))
        {
            A_subState = I;
            rootState_active = I;
            res = eventConsumed;
        }
    
    
    return res;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\CSD_1.cpp
*********************************************************************/
