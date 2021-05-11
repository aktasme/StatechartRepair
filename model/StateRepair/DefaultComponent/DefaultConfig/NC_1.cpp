/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: NC_1
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\NC_1.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "NC_1.h"
//## package _7_NestedConditions

//## class NC_1
NC_1::NC_1(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

NC_1::~NC_1() {
}

int NC_1::getX() const {
    return x;
}

void NC_1::setX(int p_x) {
    x = p_x;
}

bool NC_1::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void NC_1::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
}

void NC_1::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus NC_1::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    // State B
    if(rootState_active == B)
        {
            if(IS_EVENT_TYPE_OF(OMNullEventId))
                {
                    //## transition 2 
                    if(x == 0)
                        {
                            popNullTransition();
                            A_subState = C;
                            rootState_active = C;
                            res = eventConsumed;
                        }
                    else
                        {
                            //## transition 4 
                            if(x == 1)
                                {
                                    popNullTransition();
                                    A_subState = D;
                                    rootState_active = D;
                                    res = eventConsumed;
                                }
                            else
                                {
                                    //## transition 6 
                                    if(x == 2)
                                        {
                                            popNullTransition();
                                            A_subState = E;
                                            rootState_active = E;
                                            res = eventConsumed;
                                        }
                                    else
                                        {
                                            popNullTransition();
                                            A_subState = F;
                                            rootState_active = F;
                                            res = eventConsumed;
                                        }
                                }
                        }
                }
            
            
        }
    return res;
}

void NC_1::A_entDef() {
    rootState_subState = A;
    pushNullTransition();
    A_subState = B;
    rootState_active = B;
}

void NC_1::A_exit() {
    switch (A_subState) {
        // State B
        case B:
        {
            popNullTransition();
        }
        break;
        
        default:
            break;
    }
    A_subState = OMNonState;
    
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\NC_1.cpp
*********************************************************************/
