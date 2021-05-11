/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TBSWDH_4
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TBSWDH_4.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "TBSWDH_4.h"
//## event evBD()
#include "Default.h"
//## package _2_TransitionBetweenStatesWithDifferentHierarchy

//## class TBSWDH_4
TBSWDH_4::TBSWDH_4(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

TBSWDH_4::~TBSWDH_4() {
}

bool TBSWDH_4::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void TBSWDH_4::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
    C_subState = OMNonState;
}

void TBSWDH_4::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus TBSWDH_4::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State B
        case B:
        {
            if(IS_EVENT_TYPE_OF(evBD_Default_id))
                {
                    A_subState = C;
                    C_subState = D;
                    rootState_active = D;
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State D
        case D:
        {
            if(IS_EVENT_TYPE_OF(evDE_Default_id))
                {
                    C_subState = E;
                    rootState_active = E;
                    res = eventConsumed;
                }
            
            if(res == eventNotConsumed)
                {
                    res = C_handleEvent();
                }
        }
        break;
        // State E
        case E:
        {
            res = C_handleEvent();
        }
        break;
        default:
            break;
    }
    return res;
}

void TBSWDH_4::A_entDef() {
    rootState_subState = A;
    A_subState = B;
    rootState_active = B;
}

void TBSWDH_4::C_entDef() {
    A_subState = C;
    C_subState = D;
    rootState_active = D;
}

IOxfReactive::TakeEventStatus TBSWDH_4::C_handleEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    if(IS_EVENT_TYPE_OF(evCB_Default_id))
        {
            C_subState = OMNonState;
            A_subState = B;
            rootState_active = B;
            res = eventConsumed;
        }
    
    
    return res;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TBSWDH_4.cpp
*********************************************************************/
