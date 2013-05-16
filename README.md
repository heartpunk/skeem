#Skeem

Skeem will be an implementation of a subset of Scheme R6RS, with the initial purpose of exploring some ideas I'm interested in about language design. These may make Skeem very slow, but they all have the aim of making it a better environment to program in. I do not intend to ever make this production-ready, it is solely an experiment.

##The ideas

1. I'd like to see how far it's possible to reasonably push introspection into the guts of a programming language. My goal is to make it possible to programmatically monitor every step of parsing and execution (though perhaps not from within the same Skeem runtime you're monitoring). As well, I hope to make visualizations that consume this data.
2. The runtime should be able to go backwards and forwards. Additionally, after the runtime has rewound some steps in execution, it should be possible to change code and run it forward again. Ideally, but not necessarily, this will be represented as a tree of timelines, so that it would be possible to pick the best of many tweaks trivially. Basically, changing things shouldn't destroy the world (I believe that I'm getting that phrase from a talk Bret Victor gave at Strange Loop 2012, the best approximation to which I can find is this essay of his, called [Learnable Programming](http://worrydream.com/LearnableProgramming/).)
