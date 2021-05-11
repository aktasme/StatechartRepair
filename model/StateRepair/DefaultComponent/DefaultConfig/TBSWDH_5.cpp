/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TBSWDH_5
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TBSWDH_5.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "TBSWDH_5.h"
//## event evCB()
#include "Default.h"
//## package _2_TransitionBetweenStatesWithDifferentHierarchy

//## class TBSWDH_5
TBSWDH_5::TBSWDH_5(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

TBSWDH_5::~TBSWDH_5() {
}

bool TBSWDH_5::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void TBSWDH_5::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
    C_subState = OMNonState;
}

void TBSWDH_5::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus TBSWDH_5::rootState_processEvent() {
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
            else if(IS_EVENT_TYPE_OF(evDF__2_TransitionBetweenStatesWithDifferentHierarchy_id))
                {
                    switch (A_subState) {
                        // State C
                        case C:
                        {
                            C_subState = OMNonState;
                        }
                        break;
                        default:
                            break;
                    }
                    A_subState = OMNonState;
                    rootState_subState = F;
                    rootState_active = F;
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State E
        case E:
        {
            if(IS_EVENT_TYPE_OF(evEB_Default_id))
                {
                    C_subState = OMNonState;
                    A_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State F
        case F:
        {
            if(IS_EVENT_TYPE_OF(evFE_Default_id))
                {
                    rootState_subState = A;
                    A_subState = C;
                    C_subState = E;
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

void TBSWDH_5::A_entDef() {
    rootState_subState = A;
    A_subState = B;
    rootState_active = B;
}

void TBSWDH_5::C_entDef() {
    A_subState = C;
    C_subState = D;
    rootState_active = D;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TBSWDH_5.cpp
*********************************************************************/
