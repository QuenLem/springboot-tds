//Script generated with VueComponent at Wed Mar 13 10:04:04 CET 2019
Vue.component('m-confirm-button',{
	"props":{
		validatecaption:{
			"type":[String]
			}
		,width:{
			"default":500
			}
		,title:{
			"type":[String]
			}
		,message:{
			"type":[String]
			}
		}
	,"data":function() {
		 return {
			"dialog":false
			}
		;
		}
	,"methods":{
		"validation":function (){
			this.
			$emit('validation');
			this.dialog=false
			}
		}
	,"template":"<v-dialog v-model=\"dialog\" :width=\"width\">  <template v-slot:activator=\"{ on }\">    <v-btn color=\"red lighten-2\" dark v-on=\"on\"><slot></slot></v-btn>  </template>   <v-card>    <v-card-title class=\"headline grey lighten-2\" primary-title>      {{title}}    </v-card-title>     <v-card-text>      {{message}}    </v-card-text>     <v-divider></v-divider>     <v-card-actions>      <v-spacer></v-spacer>      <v-btn color=\"success\" @click=\"validation\">{{validatecaption}}</v-btn>    </v-card-actions>  </v-card></v-dialog>"
	}
);