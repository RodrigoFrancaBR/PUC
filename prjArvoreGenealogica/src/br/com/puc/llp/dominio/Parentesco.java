package br.com.puc.llp.dominio;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public enum Parentesco {

	SEM_PARENTESCO {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	MESMA_PESSOA {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	PAIS {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	PAI {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	MAE {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	MARIDO {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	ESPOSA {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	IRMAOS {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	IRMÃO {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	IRMÃ {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	FILHO {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	FILHA {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	TIOS {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	TIO {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	TIA {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	SOBRINHO {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	SOBRINHA {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	PRIMOS {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	PRIMO {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	PRIMA {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	AVÓS {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	AVÔ {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	AVÓ {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	NETO {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	NETA {
		@Override
		Parentesco getParentesco(Pessoa p) {
			// TODO Auto-generated method stub
			return null;
		}
	};

	public static final Parentesco obterParentesco(Pessoa pessoa) {
		Parentesco[] values = Parentesco.values();
		List<Parentesco> asList = Arrays.asList(values);
		asList.parallelStream().map(e->e.getParentesco(pessoa));
		return null;
	}

	abstract Parentesco getParentesco(Pessoa p);
}
